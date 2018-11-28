import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;




public class CreateQRCode implements ActionListener{
	
	

	
	private static String labelPrefix = "�����ı�Ϊ: ";   
    final JTextField t1 = new JTextField("�����룬�磺�����E�");
    String text1=" ";
    final JLabel label = new JLabel(labelPrefix + text1);
    
  //Specify the look and feel to use.  Valid values:  
    //null (use the default), "Metal", "System", "Motif", "GTK+"  
    final static String LOOKANDFEEL = "System";  
  
    public Component createComponents() {    
        JButton button = new JButton("�������");  
        button.setMnemonic(KeyEvent.VK_I);  
        button.addActionListener(this);  
        label.setLabelFor(button);  
        
        
  
        /* 
         * An easy way to put space between a top-level container 
         * and its contents is to put the contents in a JPanel 
         * that has an "empty" border. 
         */  
        JPanel pane = new JPanel(new GridLayout(0, 1));  
        pane.add(button); 
        pane.add(t1);
        pane.add(label);  
        pane.setBorder(BorderFactory.createEmptyBorder(  
                                        30, //top  
                                        30, //left  
                                        10, //bottom  
                                        30) //right  
                                        );  
  
        return pane;  
    }  
    

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		numClicks++;  
//        label.setText(labelPrefix + numClicks);  
		text1 = t1.getText();
		label.setText(labelPrefix + text1);
		
		
		int width = 300;
		int height = 300;
		String format = "png";
		String content=text1;

		// �����ά��Ĳ���
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 3);

		
		// ���ɶ�ά��
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

			Path file = new File("E:/qr code.png").toPath();

			MatrixToImageWriter.writeToPath(bitMatrix, format, file);

		} catch (WriterException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	private static void initLookAndFeel() {  
        String lookAndFeel = null;  
  
        if (LOOKANDFEEL != null) {  
            if (LOOKANDFEEL.equals("Metal")) {  
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();  
            } else if (LOOKANDFEEL.equals("System")) {  
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();  
            } else if (LOOKANDFEEL.equals("Motif")) {  
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";  
            } else if (LOOKANDFEEL.equals("GTK+")) { //new in 1.4.2  
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";  
            } else {  
                System.err.println("Unexpected value of LOOKANDFEEL specified: "  
                                   + LOOKANDFEEL);  
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();  
            }  
  
            try {  
                UIManager.setLookAndFeel(lookAndFeel);  
            } catch (ClassNotFoundException e) {  
                System.err.println("Couldn't find class for specified look and feel:"  
                                   + lookAndFeel);  
                System.err.println("Did you include the L&F library in the class path?");  
                System.err.println("Using the default look and feel.");  
            } catch (UnsupportedLookAndFeelException e) {  
                System.err.println("Can't use the specified look and feel ("  
                                   + lookAndFeel  
                                   + ") on this platform.");  
                System.err.println("Using the default look and feel.");  
            } catch (Exception e) {  
                System.err.println("Couldn't get specified look and feel ("  
                                   + lookAndFeel  
                                   + "), for some reason.");  
                System.err.println("Using the default look and feel.");  
                e.printStackTrace();  
            }  
        }  
    }  
	
	
	 /** 
     * Create the GUI and show it.  For thread safety, 
     * this method should be invoked from the 
     * event-dispatching thread. 
     */  
    private static void createAndShowGUI() {  
        //Set the look and feel.---������ۣ����Ժ���  
        initLookAndFeel();  
  
        //Make sure we have nice window decorations.  
        //����Ϊfalse�Ļ�����Ϊ���ı����  
        JFrame.setDefaultLookAndFeelDecorated(true);  
  
        //Create and set up the window.  
        JFrame frame = new JFrame("������ά��");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  
        CreateQRCode app = new CreateQRCode();  
        Component contents = app.createComponents();  
        frame.getContentPane().add(contents, BorderLayout.CENTER);  
  
        //Display the window.  
        frame.pack();  
        frame.setVisible(true);  
    }  
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//Schedule a job for the event-dispatching thread:  
        //creating and showing this application's GUI.  
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                createAndShowGUI();  
            }  
        });  
	}



	
	

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		//���ý���		
//
//		// ����
//		int width = 300;
//		int height = 300;
//		String format = "png";
//		String content="��������������";
//
//		// �����ά��Ĳ���
//		HashMap hints = new HashMap();
//		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
//		hints.put(EncodeHintType.MARGIN, 3);
//
//		
//		// ���ɶ�ά��
//		try {
//			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
//
//			Path file = new File("E:/qr code.png").toPath();
//
//			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
//
//		} catch (WriterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}


}
