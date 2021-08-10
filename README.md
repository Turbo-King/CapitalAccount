# Capital Account Boot

### 🌈 项目概述

个人资金账户管理系统

- [uni-app 项目](https://gitee.com/cs-learn/capitalAccount-uniapp)


### ⚡ 快速启动

1. 运行 sql 文件
2. 运行 redis
3. 修改数据库配置
   - application.yml
   - application-dev.yml
4. 启动项目


### 🔨 项目结构

```
Capital Account Boot
│
├─pear-common 公共模块
│  │
│  ├─config 框架集成配置
│  │
│  ├─constant 通用常量
│  │
│  ├─exception 异常处理
│  │
│  ├─plugins 封装组件
│  │
│  ├─tools 工具类
│  │
│  └─web WEB 处理封装
│
├─pear-entrance 启动模块
│  │
│  ├─api 通用接口
│  │
│  ├─secure 安全框架
│  │
│  └─EntranceApplication 启动类
│
├─pear-entrance 启动模块
│  │
│  ├─static 静态资源
│  │
│  ├─templates 页面文件
│  │
│  ├─logback-spring.xml 日志配置
│  │
│  ├─application-dev.yml 开发环境配置
│  │
│  ├─application-prod.yml 线上环境配置
│  │
│  ├─application-test.yml 测试环境配置
│  │
│  └─application.yml 配置文件
│
├─pear-modules 业务模块
│  │
│  ├─pear-generator 代码生成
│  │
│  ├─pear-system 系统业务
│  │
│  ├─pear-schedule 定时任务
│  │
│  └─pear-process 工作流程
│  
├─sql  项目SQL文件
│
└─pom.xml  Maven 配置
```


### 💐 特别鸣谢

- 👉 Pear Admin Boot [https://gitee.com/pear-admin/Pear-Admin-Boot](https://gitee.com/pear-admin/Pear-Admin-Boot)
- 👉 Spring Boot：[https://github.com/spring-projects/spring-boot](https://github.com/spring-projects/spring-boot)


### 🍻 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request

如果这个项目帮助了你，请给一个 ⭐️ Star ⭐️ !