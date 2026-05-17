$ErrorActionPreference = 'Stop'

$Pids = netstat -ano | Select-String ':8080' | ForEach-Object { ($_ -split '\s+')[-1] } | Select-Object -Unique
foreach ($ProcessId in $Pids) {
    if ($ProcessId -match '^\d+$') {
        Stop-Process -Id ([int]$ProcessId) -Force -ErrorAction SilentlyContinue
    }
}
