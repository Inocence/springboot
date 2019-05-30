## Springboot练习与理解
### 创建项目
- 选择springboot initializr
### 部署方式
#### jar包方式
- mvn install生成jar包
#### war包方式
- 修改application代码
- 修改pom的packaging值为war
- mvn clean package
### 自动装配原理
- 通过@EnableAutoConfiguration加载配置文件
- 解析配置文件，根据条件加载bean到spring中
