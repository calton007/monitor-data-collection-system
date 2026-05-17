param(
    [switch]$SkipBuild
)

$ErrorActionPreference = 'Stop'

$Root = (Resolve-Path (Join-Path $PSScriptRoot '..')).Path
$JavaHome = 'C:\Program Files\Eclipse Adoptium\jdk-25.0.1.8-hotspot'
$Maven = Join-Path $Root '.tools\apache-maven-3.9.9\bin\mvn.cmd'
$Tomcat = Join-Path $Root '.tools\apache-tomcat-11.0.14'
$Webapps = Join-Path $Tomcat 'webapps'
$War = Join-Path $Root 'target\RG.war'
$TargetWar = Join-Path $Webapps 'RG.war'
$TargetDir = Join-Path $Webapps 'RG'

if (-not (Test-Path $JavaHome)) {
    throw "JDK 25 not found: $JavaHome"
}
if (-not (Test-Path $Maven)) {
    throw "Maven not found: $Maven"
}
if (-not (Test-Path $Tomcat)) {
    throw "Tomcat 11 not found: $Tomcat"
}

$env:JAVA_HOME = $JavaHome
$env:CATALINA_HOME = (Resolve-Path $Tomcat).Path
$env:CATALINA_BASE = (Resolve-Path $Tomcat).Path

if (-not $SkipBuild) {
    & $Maven '-Dmaven.repo.local=.m2\repository' -q clean package
}

$Pids = netstat -ano | Select-String ':8080' | ForEach-Object { ($_ -split '\s+')[-1] } | Select-Object -Unique
foreach ($ProcessId in $Pids) {
    if ($ProcessId -match '^\d+$') {
        Stop-Process -Id ([int]$ProcessId) -Force -ErrorAction SilentlyContinue
    }
}
Start-Sleep -Seconds 2

if (Test-Path $TargetDir) {
    Remove-Item -LiteralPath (Resolve-Path $TargetDir).Path -Recurse -Force
}
if (Test-Path $TargetWar) {
    Remove-Item -LiteralPath $TargetWar -Force
}
Copy-Item -LiteralPath $War -Destination $TargetWar -Force

Start-Process -FilePath (Join-Path $Tomcat 'bin\catalina.bat') -ArgumentList 'run' -WorkingDirectory $Tomcat -WindowStyle Hidden
Start-Sleep -Seconds 8

netstat -ano | Select-String ':8080|:8005'
