//Irdina binti Ahmad Hilmi 1191200256
package FinalProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;  //to create the blackline

import static FinalProject.FinalProject.*;
import static FinalProject.FinalProject.lbAns;

public class FinalProject extends JFrame implements ActionListener{
    static boolean RedCircle;
    public static int cursorX, cursorY;
    private MoveCircle drag;
    static JTextField tfCenterx1, tfCentery1 ,tfRadius1,tfCenterx2 ,tfCentery2,tfRadius2;
    static JLabel lbAns = new JLabel();
    JButton btRedraw;

    public static void main (String [] args)
    {
        FinalProject f = new FinalProject();
        f.setTitle("Final Project - Circle");
        f.setSize(350,400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public FinalProject(){

        JLabel lbIntersect = new JLabel("Two circles intersect?");

        JLabel lbInfo1 = new JLabel("Enter circle 1 info");
        JLabel lbCenterx1 = new JLabel("Center X:");
        JLabel lbCentery1 = new JLabel("Center Y:");
        JLabel lbRadius1 = new JLabel("Radius:");
        JLabel lbInfo2 = new JLabel("Enter circle 2 info");
        JLabel lbCenterx2 = new JLabel("Center X:");
        JLabel lbCentery2 = new JLabel("Center Y:");
        JLabel lbRadius2 = new JLabel("Radius: ");

        tfCenterx1 = new JTextField();
        tfCentery1 = new JTextField();
        tfRadius1 = new JTextField();
        tfCenterx2 = new JTextField();
        tfCentery2 = new JTextField();
        tfRadius2 = new JTextField();

        JLabel e1 = new JLabel();
        JLabel e2 = new JLabel();
        JLabel e3 = new JLabel();
        JLabel e4 = new JLabel();
        JLabel e5 = new JLabel();

        this.btRedraw = new JButton("Redraw circle");

        //to create black border
        Border blackline = BorderFactory.createLineBorder(Color.BLACK);

        //top panel for the question and answer of the intersection
        JPanel TOP = new JPanel();
        TOP.add(lbIntersect);
        TOP.add(lbAns);

        JPanel column1 = new JPanel();
        JPanel column2 = new JPanel();

        column1.setLayout(new GridLayout(4,1));
        column2.setLayout(new GridLayout(4,1));

        column1.setBorder(blackline);
        column2.setBorder(blackline);

        //circle 1 info
        JPanel col1row1 = new JPanel();
        col1row1.add(lbInfo1);

        JPanel col1row2 = new JPanel();
        col1row2.setLayout(new GridLayout(1,2));
        col1row2.add(lbCenterx1);
        col1row2.add(tfCenterx1);

        JPanel col1row3 = new JPanel();
        col1row3.setLayout(new GridLayout(1,2));
        col1row3.add(lbCentery1);
        col1row3.add(tfCentery1);

        JPanel col1row4 = new JPanel();
        col1row4.setLayout(new GridLayout(1,2));
        col1row4.add(lbRadius1);
        col1row4.add(tfRadius1);

        column1.add(col1row1);
        column1.add(col1row2);
        column1.add(col1row3);
        column1.add(col1row4);

        //Circle 2 info
        JPanel col2row1 = new JPanel();
        col2row1.add(lbInfo2);

        JPanel col2row2 = new JPanel();
        col2row2.setLayout(new GridLayout(1,2));
        col2row2.add(lbCenterx2);
        col2row2.add(tfCenterx2);

        JPanel col2row3 = new JPanel();
        col2row3.setLayout(new GridLayout(1,2));
        col2row3.add(lbCentery2);
        col2row3.add(tfCentery2);

        JPanel col2row4 = new JPanel();
        col2row4.setLayout(new GridLayout(1,2));
        col2row4.add(lbRadius2);
        col2row4.add(tfRadius2);

        column2.add(col2row1);
        column2.add(col2row2);
        column2.add(col2row3);
        column2.add(col2row4);

        //table and button panel
        JPanel BOTTOM = new JPanel();
        //BOTTOM.setLayout (new GridLayout(2,1));

        JPanel bottom1 = new JPanel(); //table
        JPanel bottom2 = new JPanel(); //button
        bottom1.setLayout(new GridLayout(1,2));
        bottom2.setLayout(new GridLayout(2,3));

        bottom1.add(column1);
        bottom1.add(column2);

        bottom2.add(e1);
        bottom2.add(this.btRedraw);
        bottom2.add(e2);
        bottom2.add(e3);
        bottom2.add(e4);
        bottom2.add(e5);
        // BOTTOM.add(bottom1);
        BOTTOM.add(bottom2);

        //middle panel to add the circle and the table for the infos
        JPanel MIDDLE = new JPanel();
        MIDDLE.setLayout(new GridLayout(2,1));
        MIDDLE.add(this.drag = new MoveCircle());
        MIDDLE.add(bottom1);

        //to give space
        JPanel LEFT = new JPanel();
        JPanel RIGHT = new JPanel();

        add(TOP,BorderLayout.NORTH);
        add(MIDDLE,BorderLayout.CENTER);
        add(RIGHT,BorderLayout.EAST);
        add(LEFT,BorderLayout.WEST);
        add(BOTTOM,BorderLayout.SOUTH);

        btRedraw.addActionListener(this);   //to register button
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btRedraw){  //if Redraw button is press
            drag.getInput();//display the user's new input

            //this.repaint();
        }
    }
}

class MoveCircle extends JPanel implements MouseListener,MouseMotionListener {
    //declarations for both the circles
    int x1,y1,r1,x2,y2,r2;
    int newx1 = x1-r1;
    int newy1 = y1-r1;
    int newx2 = x2-r2;
    int newy2 = y2-r2;

    //mutator method to get new input
    public void getInput() {
        this.x1 = Integer.parseInt(FinalProject.tfCenterx1.getText());  //the input is received and parsed
        this.y1 = Integer.parseInt(FinalProject.tfCentery1.getText());
        this.r1 = Integer.parseInt(FinalProject.tfRadius1.getText());
        this.x2 = Integer.parseInt(FinalProject.tfCenterx2.getText());
        this.y2 = Integer.parseInt(FinalProject.tfCentery2.getText());
        this.r2 = Integer.parseInt(FinalProject.tfRadius2.getText());
        this.newx1 = this.x1-this.r1;
        this.newy1 = this.y1-this.r1;
        this.newx2 = this.x2-this.r2;
        this.newy2 = this.y2-this.r2;
        this.repaint();//repaint after new input
    }

    public void paintComponent(Graphics circle){
        super.paintComponent(circle);

        circle.setColor(Color.red);
        circle.drawOval(this.newx1,this.newy1,this.r1*2,this.r1*2);  //gets the initialization of the circle
        circle.setColor(Color.blue);
        circle.drawOval(this.newx2,this.newy2,this.r2*2,this.r2*2);

        this.repaint();
        //intersection formula
        double distance = Math.sqrt((((this.newx2 + this.r2) - (this.newx1 + this.r1)) * ((this.newx2 + this.r2) - (this.newx1 + this.r1)))
                + (((this.newy2 + this.r2) - (this.newy1 + this.r1)) * ((this.newy2 + this.r2) - (this.newy1 + this.r1))));
        double radius1 = this.r1;
        double radius2 = this.r2;
        if ((distance == radius1 + radius2)){
            lbAns.setText("No");
        } else if (distance>radius1+radius2) {
            lbAns.setText("No");
        } else {
            lbAns.setText("Yes");
        }

    }
    public MoveCircle(){
        //any new values overrides and display the old value
        tfCenterx1.setText(String.valueOf(this.x1));
        tfCentery1.setText(String.valueOf(this.y1));
        tfRadius1.setText(String.valueOf(this.r1));
        tfCenterx2.setText(String.valueOf(this.x2));
        tfCentery2.setText(String.valueOf(this.y2));
        tfRadius2.setText(String.valueOf(this.r2));
        this.addMouseListener(this);        //to register the mouselistener
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if (x >= this.newx2 && (x < this.newx2 + (this.r2 * 2)) && (y >= this.newy2) && (y < this.newy2 + (this.r2 * 2))) {
            RedCircle = false;
            cursorX = x - this.newx2;
            cursorY = y - this.newy2;
        }

        if (x >= this.newx1 && (x < this.newx1 + (this.r1 * 2)) && (y >= this.newy1) && (y < this.newy1 + (this.r1 * 2))) {
            RedCircle = true;
            cursorX = x - this.newx1;
            cursorY = y - this.newy1;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if(RedCircle){   //drag red
            this.newx1 = x - cursorX;
            this.newy1 = y - cursorY;
        }
        else{      //drag blue
            this.newx2 = x - cursorX;
            this.newy2 = y - cursorY;
        }

        this.x1 = this.newx1 + this.r1;
        this.y1 = this.newy1 + this.r1;
        this.x2 = this.newx2 + this.r2;
        this.y2 = this.newx2 + this.r2;

        //set the text inside the table
        tfCenterx1.setText(""+this.x1);
        tfCentery1.setText(""+this.y1);
        tfRadius1.setText(""+this.r1);

        tfCenterx2.setText(""+this.x2);
        tfCentery2.setText(""+this.y2);
        tfRadius2.setText(""+this.r2);

        //intersection formula
        double distance = Math.sqrt((((this.newx2 + this.r2) - (this.newx1 + this.r1)) * ((this.newx2 + this.r2) - (this.newx1 + this.r1)))
                + (((this.newy2 + this.r2) - (this.newy1 + this.r1)) * ((this.newy2 + this.r2) - (this.newy1 + this.r1))));
        double radius1 = this.r1;
        double radius2 = this.r2;
        if ((distance == radius1 + radius2)){
            lbAns.setText("No");
        } else if (distance>radius1+radius2) {
            lbAns.setText("No");
        } else {
            lbAns.setText("Yes");
        }
        this.repaint();  //clear and repaint
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}



