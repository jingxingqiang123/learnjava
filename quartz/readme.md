1、JobExecutionContext  获取Quartz调度的上下文
Job：是一个接口，只定义一个方法 execute（JobExecutionContext context），在实现接口的 execute 方法中编写所需要定时执行的 Job（任务），
JobExecutionContext 类提供了调度应用的一些信息；Job 运行时的信息保存在 JobDataMap 实例中。

2、JobDetail: 任务详情。Quartz 每次调度 Job 时，都重新创建一个 Job 实例，因此它不接受一个 Job 的实例，
  相反它接收一个 Job 实现类（JobDetail，描述 Job 的实现类及其他相关的静态信息，如 Job 名字、描述、关联监听器等信息），
  以便运行时通过 newInstance() 的反射机制实例化 Job。

3、trigger: 触发器，任务执行的规则 。 
主要有 SimpleTrigger 和 CronTrigger 这两个子类。
  3.1、当且仅当需调度一次或者以固定时间间隔周期执行调度，SimpleTrigger 是最适合的选择；
  3.2、 CronTrigger 则可以通过 Cron 表达式定义出各种复杂时间规则的调度方案：如工作日周一到周五的 15：00 ~ 16：00 执行调度等。
4、Scheduler：调度器就相当于一个容器，装载着任务和触发器，该类是一个接口，代表一个 Quartz 的独立运行容器，Trigger 和 JobDetail
  可以注册到 Scheduler 中，两者在 Scheduler 中拥有各自的组及名称，组及名称是 Scheduler 查找定位容器中某一对象的依据，
  Trigger 的组及名称必须唯一，JobDetail 的组和名称也必须唯一（但可以和 Trigger 的组和名称相同，因为它们是不同类型的）。
  Scheduler 定义了多个接口方法，允许外部通过组及名称访问和控制容器中 Trigger 和 JobDetail。 
   