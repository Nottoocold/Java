## 自动装配autowire-xml

1.ByType 当在容器中根据类型匹配不到目标时，则使用默认值 此方式要求IOC容器中 目标类型有且只有一个类型匹配的Bean ​ 2.ByName 通过容器中Bean的id来匹配，当自身属性名与IOC容器中有一个id匹配则成功

## 自动装配autowire-annotation

1.标记与扫描 ​ 1>注解 标记 ​ 2>扫描 扫描类->扫描判断是否有注解

### 常用4个注解

***@Component*** 将类标识为普通组件  
***@Controller*** 将类标识为控制层组件  
***@Service*** 将类标识为业务层组件  
***@Repository***  将类标识为持久层组件

```java
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component // 通过源码可知 Controller、Service、Repository 都只是Component的别名 对于Spring来说都是一样的（都是Component)
public @interface Controller {
    @AliasFor(annotation = Component.class)
    String value() default ""; // value属性指定组件的唯一ID

}
```

### 扫描组件

1.最基本的扫描方式

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<context:component-scan base-package="..."/>
```

2.指定要排除的组件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<context:component-scan base-package="...">
    <!--<context:exclude-filter> 标签指定排除规则
        type 指定排除或包含的依据
        type="annotation" 根据注解排除 expression表达式中设置要排除的注解的全类名
        type="assignable" 根据类型排除 expression表达式在设置要排除的类型的全类名
    -->
</context:component-scan>
```

3.进扫描指定组件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<context:component-scan base-package="...">
    <!--<context:include-filter 标签指定在原有规则上追加扫描规则
        use-default-filters 属性取值此时必须要关闭,否则等于没配置
        type 指定排除或包含的依据
        type="annotation" 根据注解排除 expression表达式中设置要排除的注解的全类名
        type="assignable" 根据类型排除 expression表达式在设置要排除的类型的全类名    
    >-->
</context:component-scan>
```

### 自动装配

***@Autowire*** 自动装配注解 可用在类，构造器，set方法上  
工作流程:  
根据类型匹配，匹配成功则结束；若匹配到的类型不止一个，则把属性名当作id匹配，若两种方式均不行,判断是否有@Qualifier注解，有则将其值当作id进行匹配；

## AOP

AOP（Aspect Oriented Programming）是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现在不修改源代码的情况
下给程序动态统一添加额外功能的一种技术。

### 相关术语

1. **横切关注点**

从每个方法中抽取出来的同一类非核心业务。在同一个项目中，我们可以使用多个横切关注点对相关方 法进行多个不同方面的增强。 这个概念不是语法层面天然存在的，而是根据附加功能的逻辑上的需要：有十个附加功能，就有十个横切关注点。

2. **通知**

每一个横切关注点上要做的事情都需要写一个方法来实现，这样的方法就叫通知方法。

+ 前置通知：在被代理的目标方法前执行
+ 返回通知：在被代理的目标方法成功结束后执行（寿终正寝）
+ 异常通知：在被代理的目标方法异常结束后执行（死于非命）
+ 后置通知：在被代理的目标方法最终结束后执行（盖棺定论）
+ 环绕通知：使用try...catch...finally结构围绕整个被代理的目标方法，包括上面四种通知对应的所 有位置

3.**切面**

封装通知方法的类

4.**目标**

被代理的目标对象

5.**代理**

向目标对象应用通知之后创建的代理对象。

6.**连接点**

这也是一个纯逻辑概念，不是语法定义的。 把方法排成一排，每一个横切位置看成x轴方向，把方法从上到下执行的顺序看成y轴，x轴和y轴的交叉点就是连接点。

7.**切入点(代码实现)**

定位连接点的方式。 每个类的方法中都包含多个连接点，所以连接点是类中客观存在的事物（从逻辑上来说）。 如果把连接点看作数据库中的记录，那么切入点就是查询记录的 SQL 语句。 Spring 的 AOP 技术可以通过切入点定位到特定的连接点。
切点通过 org.springframework.aop.Pointcut 接口进行描述，它使用类和方法作为连接点的查询条 件。

#### 作用

+ 简化代码：把方法中固定位置的重复的代码抽取出来，让被抽取的方法更专注于自己的核心功能， 提高内聚性。
+ 代码增强：把特定的功能封装到切面类中，看哪里有需要，就往上套，被套用了切面逻辑的方法就 被切面给增强了。

### 事务管理

自己写代码管理事务称为编程式事务管理，如下所示

```java
try{
    conn.setAutoCommit(false);
    //...
    conn.commit():
}catch(Exception e){
    conn.rollBack();
}finally{
    /...
}
```

编程式的实现方式存在缺陷：

+ 细节没有被屏蔽：具体操作过程中，所有细节都需要程序员自己来完成，比较繁琐。
+ 代码复用性不高：如果没有有效抽取出来，每次实现功能都需要自己编写代码，代码就没有得到复用。

#### 声明式事务

既然事务控制的代码有规律可循，代码的结构基本是确定的，所以框架就可以将固定模式的代码抽取出来，进行相关的封装。 封装起来后，我们只需要在配置文件中进行简单的配置即可完成操作。

- 好处1：提高开发效率

- 好处2：消除了冗余的代码

- 好处3：框架会综合考虑相关领域中在实际开发环境下有可能遇到的各种问题，进行了健壮性、性能等各个方面的优化

  所以，我们可以总结下面两个概念：

    - 编程式：自己写代码实现功能
    - 声明式：通过配置让框架实现功能

#### 基于注解的声明式事务

```xml
<bean id="transactionManager"
class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
<property name="dataSource" ref="dataSource"></property>
</bean>
<!--
开启事务的注解驱动
通过注解@Transactional所标识的方法或标识的类中所有的方法，都会被事务管理器管理事务
-->
<!-- transaction-manager属性的默认值是transactionManager，如果事务管理器bean的id正好就
是这个默认值，则可以省略这个属性 -->
<tx:annotation-driven transaction-manager="transactionManager" />
```

**@Transactional**   注解标识哪些方法需要事务管理，可作用方法或类上。具体注解属性可查看文档。

声明式事务默认只针对运行时异常回滚，编译时异常不回滚。 可以通过@Transactional中相关属性设置回滚策略

+ rollbackFor属性：需要设置一个Class类型的对象
+ rollbackForClassName属性：需要设置一个字符串类型的全类名
+ noRollbackFor属性：需要设置一个Class类型的对象
+ rollbackFor属性：需要设置一个字符串类型的全类名

当出现。。。执行回滚

当出现。。。不执行回滚

#### 事务属性-事务的隔离级别

```java
@Transactional(isolation = Isolation.DEFAULT)//使用数据库默认的隔离级别
@Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交
@Transactional(isolation = Isolation.READ_COMMITTED)//读已提交
@Transactional(isolation = Isolation.REPEATABLE_READ)//可重复读
@Transactional(isolation = Isolation.SERIALIZABLE)//串行化
```

#### 事务属性-事务的传播行为

当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中 运行，也可能开启一个新事务，并在自己的事务中运行。

```java
@Transactional(propagation = Propagation.REQUIRED)//默认情况，方法的执行处于同一事务中
@Transactional(propagation = Propagation.REQUIRES_NEW)//表示不管当前线程上是否有已经开启
														//的事务，都要开启新事务
```

#### 基于xml的声明式事务

```xml
<aop:config>
<!-- 配置事务通知和切入点表达式 -->
<aop:advisor advice-ref="txAdvice" pointcut="execution(*com.zyc.spring.tx.xml.service.impl.*.*(..))"></aop:advisor>
</aop:config>

<!-- tx:advice标签：配置事务通知 -->
<!-- id属性：给事务通知标签设置唯一标识，便于引用 -->
<!-- transaction-manager属性：关联事务管理器 -->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
    <!-- tx:method标签：配置具体的事务方法 -->
    <!-- name属性：指定方法名，可以使用星号代表多个字符 -->
    <tx:method name="get*" read-only="true"/>
    <tx:method name="query*" read-only="true"/>
    <tx:method name="find*" read-only="true"/>
    <!-- read-only属性：设置只读属性 -->
    <!-- rollback-for属性：设置回滚的异常 -->
    <!-- no-rollback-for属性：设置不回滚的异常 -->
    <!-- isolation属性：设置事务的隔离级别 -->
    <!-- timeout属性：设置事务的超时属性 -->
    <!-- propagation属性：设置事务的传播行为 -->
    <tx:method name="save*" read-only="false" rollback-for="java.lang.Exception" propagation="REQUIRES_NEW"/>
    <tx:method name="update*" read-only="false" rollback-for="java.lang.Exception" propagation="REQUIRES_NEW"/>
    <tx:method name="delete*" read-only="false" rollback-for="java.lang.Exception" propagation="REQUIRES_NEW"/>
    </tx:attributes>
</tx:advice>

<!--基于xml实现事务 需引入依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.3.1</version>
</dependency>
```

