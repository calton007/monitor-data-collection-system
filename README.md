# monitor-data-collection-system

监测信息获取系统。项目已迁移到 Jakarta 新栈，但架构保持不变：

```text
JSP + Struts Action + Service + DAO + Hibernate + MySQL
```

不使用 Spring Boot，不重写前端。

## 当前技术栈

| 项目 | 版本 |
|---|---|
| JDK | 25 |
| Web 容器 | Tomcat 11 |
| Servlet/JSP | Jakarta EE |
| Struts | 7.x |
| Hibernate | 7.x |
| MySQL 驱动 | Connector/J 9.x |
| 数据库 | MySQL 8.x |

## 本地构建

如果系统 PATH 里没有 Maven，使用仓库内 `.tools` 目录下的 Maven：

```powershell
$env:JAVA_HOME='C:\Program Files\Eclipse Adoptium\jdk-25.0.1.8-hotspot'
$env:Path="$env:JAVA_HOME\bin;$PWD\.tools\apache-maven-3.9.9\bin;$env:Path"
mvn '-Dmaven.repo.local=.m2\repository' clean package
```

构建成功后生成：

```text
target/RG.war
```

## 数据库

默认数据库配置在：

```text
RG/src/hibernate.cfg.xml
```

默认连接：

```text
jdbc:mysql://localhost:3306/rg
username=root
password=root
```

导入数据：

```powershell
mysql -uroot -proot < rg.sql
```

测试账号：

| 用户名 | 密码 |
|---|---|
| test | test |
| aaa | aaa |
| bbb | bbb |

## 启动

启动脚本会部署 `target/RG.war` 到本地 Tomcat 11，并启动 8080 端口：

```powershell
powershell -ExecutionPolicy Bypass -File scripts/start-tomcat11.ps1
```

如果已经构建过，可以跳过构建：

```powershell
powershell -ExecutionPolicy Bypass -File scripts/start-tomcat11.ps1 -SkipBuild
```

访问：

```text
http://localhost:8080/RG/login.jsp
```

停止：

```powershell
powershell -ExecutionPolicy Bypass -File scripts/stop-tomcat11.ps1
```

## 已完成的迁移修复

| 模块 | 说明 |
|---|---|
| Jakarta | `web.xml` 和 Servlet/JSP 依赖已迁移到 Jakarta |
| Struts 7 | Action 参数 setter 已加 `@StrutsParameter` |
| OGNL 访问 | `com.file` 实体包已加入 Struts allowlist，JSP 可正常显示用户和项目信息 |
| Hibernate 7 | DAO 写入 API 已改为 `persist`、`merge`、`remove` |
| 查询结果 | 查询结果页按任务 `id` 获取监测点和日期，避免 URL 日期参数截断 |
| 页面布局 | 修复登录页、后台顶部、页脚、空状态和图表字体问题 |

## 主要流程

| 页面 | 入口 |
|---|---|
| 登录 | `/RG/login.jsp` |
| 首页 | `/RG/getByUserId.action` |
| 评价项目 | `/RG/updateProj.action` |
| 监测任务 | `/RG/queryProj.action` |
| 账户信息 | `/RG/profile.jsp` |

## 注意事项

- `.tools/`、`.m2/`、`target/` 是本地工具和构建缓存，不进入 Git。
- `RG/WebRoot` 下的 CSS、JS、图片、JSP、Struts/Hibernate XML 是运行必需文件，应进入 Git。
- 当前数据库账号密码只适合本地演示，不是生产配置。
