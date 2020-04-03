<%@ page language="java"
    import="java.util.*"
    import="java.awt.*"
    import="java.awt.image.BufferedImage"
    import="javax.imageio.ImageIO"
    pageEncoding="UTF-8"
%>
<%
    response.setHeader("Cache-Control","no-cache");
    int width = 60;
    int height = 20;
    int length = 4;
    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    //设置画笔
    Graphics g = image.getGraphics();
    //设定背景颜色
    g.setColor(new Color(200,200,200));
    g.fillRect(0, 0, width, height);
    //取随机产生的验证码（四位数字）
    
    String randStr = "";  
    Random random = new Random();  
    for (int i = 0; i < length; i++) {  
        boolean b = random.nextBoolean();  
        if (b) { // 字符串  
            int choice = random.nextBoolean() ? 65 : 97; //取得65大写字母还是97小写字母  
            randStr += (char) (choice + random.nextInt(26));// 取得大写字母  
        } else { // 数字  
            randStr += String.valueOf(random.nextInt(10));  
        }  
    }  
    session.setAttribute("randStr", randStr);
    System.out.println("\n验证码为："+randStr+"\n");
    session.setAttribute("randStr", randStr);
    //将验证码显示到图像中
    g.setColor(Color.black);
    g.setFont(new Font("",Font.PLAIN,20));
    g.drawString(randStr,5,17);
    //随机产生100个干扰点，使图像不容易被其它程序探测
    for(int i=0; i<100; i++){
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        g.drawOval(x,y,1,1);
    }
    //输出图像的到页面
    ImageIO.write(image,"JPEG",response.getOutputStream());
    out.clear();
    out = pageContext.pushBody();
%>