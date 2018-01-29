> 参考地址： https://www.cnblogs.com/lovekxc/p/6899755.html
> 参考地址： https://www.cnblogs.com/chenfeng1122/p/6270217.html

##使用@Autowired注入static变量会失败，提供如下解决：

```$xslt
@Component //此处注解不能省却（0）
public class NtClient {
    /**
     * 日志
     */
    private static String clazzName = NtClient.class.getName();
    /**
     * 此处是要使用的service需要spring注入（1）
     */
    @Autowired
    private NotifyTimeService notifyTimeService;
    private static NtClient ntClient;
    /**
     * 注意此处注解（2） */
    @PostConstruct
    public void init() {
        ntClient = this;
        ntClient.notifyTimeService = this.notifyTimeService;
    }
    /**
     * 主要使用场景（3）
     */
    public static void insertParam(int id){
        /**
         * 注意此处的调用方法（4）
         */
        if(ntClient.notifyTimeService.deleteNotifyTime(id)){
        }
    }
}

```

注释：
* （0）处作用是将（2）ntClient = this;this进行赋值（注：如果无注解ntClient 将null）
* （1）处为spring自动注入，使用spring框架的很常用，但是如果在静态方法中调用此注入类的方法，发现注入为'null'；原因不是spring未注入，而是被static方法给'清空'了，在无法先于static方法初始化之前想了一个办法
* （2）处为想到的办法：通过（注：@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。PostConstruct在构造函数之后执行,init()方法之前执行。PreDestroy（）方法在destroy()方法执行执行之后执行）的方法public void init()先给该类赋值，然后通过（1）出注入进来。这样不影响dao等service下面调用的注入！
* （3）处要处理的特殊方法static（经典是 main（）方法，自己想想基础，它里面可以使用的方法调用的模式）
* （4）处是使用这样模式的调用方式notifyTimeService现在是作为ntClient的属性