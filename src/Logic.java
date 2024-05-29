public class Logic {
    public static void quit(){
        System.exit(0);
    }
    public static void open(){
        System.out.println("Open");
    }
    public static void   circle(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.CIRCLE);
    }
    public static void  square(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.SQUARE);
    }
    public static void  line(DrawPanel drawPanel){
        drawPanel.setWhatIsPainting(WhatIsPainting.LINE);
    }
}
