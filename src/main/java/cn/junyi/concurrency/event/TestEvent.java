package cn.junyi.concurrency.event;

/**
 * 测试类
 * Created by goujy on 3/18/17.
 */
public class TestEvent{
    public TestEvent(EventSourceObject eso){
        eso.registerListener(new CusEventListener(){
            @Override
            public void fireCusEvent(CusEvent ce) {
                super.fireCusEvent(ce);
            }
        });
    }


    public static void main(String[] args) {
        EventSourceObject eso = new EventSourceObject();
        new TestEvent(eso);
        eso.setName("li jun");
        eso.setName("junyi");


        //
       //Method one
        // * eso.registerListener(new CusEventListener(){
           // @Override
           //public void fireCusEvent(CusEvent ce) {
           //     super.fireCusEvent(ce);
           //}
       // });*/
        
        //Method two
        //eso.registerListener(new CusEventListener());
        
        /*eso.registerListener(new CusEventListener(){
            @Override
            public void fireCusEvent(CusEvent ce) {
                super.fireCusEvent(ce);
                System.out.println("ce.getSource() = " + ce.getSource());
            }
        });
        */
        
        //CusEventListener cel = new CusEventListener();
        //eso.registerListener(cel);

        //eso.setName("li jun");
    }
}
