import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Announcement  extends JFrame implements ActionListener{
  //Variable and GUIObject Declaration area
  File chaplency, sports, clubs, civies, paday, teachers, other, file;
  JPanel panel1, panel2, panel3, panel4, panel5;
  JLabel name, category,choose, type;
  JTextField ntext, message, ctext;
  JButton enter, edit,create, old, enter2,select ,select2;
  JTextPane area, pane2;
  JScrollPane scroll, scroll2;
  int green=0;
  String[] options={"Select one","Chaplancy","Sports","Clubs","Civies","P.A.DAY","Other"};
  JComboBox<String> menu, menu2 ;
  String    area2, names, check;
  int number=0;
  PrintWriter out=null;
  DefaultListModel model1, model2;
  JList list1, list2;
  BufferedReader in=null;
  String []go;
  public static void main(String[ ] args)
  {
    new Announcement ();
  }
  public Announcement  ()
  {
    
    chaplency=new File("Chaplancy.txt");
    sports=new File("Sports.txt");
    clubs=new File("Clubs.txt");
    civies=new File("Civies.txt");
    paday=new File("P.A.Day.txt");
    other=new File("Other.txt");
    area2=new String();
    
//main panel
    panel1=new JPanel();
    this.add(panel1);
    panel1.setLayout(null);
    panel1.setBackground(Color.BLUE);
    panel2=new JPanel();
    panel1.add(panel2);
    
    //name
    name= new JLabel("Enter your last name");
    JLabel empty2=new JLabel("");
    panel2.add(name);
    
    ntext=new JTextField("");
    panel2.add(ntext);
    
    
    enter=new JButton("ENTER");
    enter.addActionListener(this);
    panel2.add(enter);
    panel2.setBackground(Color.RED);
    panel2.setLayout(new GridLayout(1,3,5,0));
    panel2.setBounds(20, 130, 430, 70);
    panel3=new JPanel();
    panel1.add(panel3);
    panel3.setVisible(false);
    
    //panel3
    choose=new JLabel("choose one from the following:");
    panel3.add(choose);
    JLabel empty=new JLabel("");
    panel3.add(empty);
    old=new JButton("edit an old announcement");
    panel3.add(old);    
    old.addActionListener(this);  
    create=new JButton("write a new announcement");
    panel3.add(create);
    create.addActionListener(this);
    panel3.setBackground(Color.GREEN);
    panel3.setLayout(new GridLayout(2,2,5,0));
    panel3.setBounds(20, 130, 430, 140);
    
    //panel4
    panel4=new JPanel();
    panel1.add(panel4);    
    panel4.setVisible(false);    
    category=new JLabel("Choose your category");
    panel4.add(category);
    menu = new JComboBox<String>(options);
    menu.setSelectedItem(options);
    menu.addActionListener(this);
    panel4.add(menu);
    select=new JButton("Select");
    select.addActionListener(this);
    panel4.add(select);
    
    type=new JLabel("Type your announcement here:");
    panel4.add(type);
    area=new JTextPane();
    panel4.add(area);
    scroll=new JScrollPane(area);
    panel4.add(scroll);
    
    enter2=new JButton("enter");
    enter2.addActionListener(this);
    panel4.add(enter2);
    
    panel4.setBackground( Color.BLACK);
    category.setForeground( Color.WHITE);
    type.setForeground( Color.WHITE);
    panel4.setBounds(10, 20, 440, 400);
    panel4.setLayout(new GridLayout(2,3,1,25));
    
    //panel5
    panel5=new JPanel();
    panel1.add(panel5);
    
    menu2 = new JComboBox<String>(options);
    menu2.setSelectedItem(options);
    menu2.addActionListener(this);
    
    panel5.add(menu2);
    select2=new JButton("Select");
    select2.addActionListener(this);
    panel5.add(select2);
    
    panel5.setVisible(false);   
    model2=new DefaultListModel();
    list2=new JList(model2);
    scroll2=new JScrollPane(list2);
    
    panel5.add(scroll2);
    
    panel5.setBounds(20, 40, 400, 350);
    panel5.setLayout(new GridLayout(2,1));
    panel5.setBackground(Color.CYAN);
    
    
    this.setSize(500,600);
    this.setVisible(true);
    this.setLayout(null);
  }  
  public void actionPerformed(ActionEvent e) {
    
    if (e.getSource()==enter)
    {
      System.out.println(ntext.getText());
      panel2.setVisible(false);
      panel3.setVisible(true);
    }
    
    if (e.getSource()==create)
    {
      panel3.setVisible(false);
      panel4.setVisible(true);
    }
    
    
    if(e.getSource()==select)
    {
      names=(String)menu.getSelectedItem();
      menu.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      if(names.equals("Sports"))
      {             
        try
        {
          out=new PrintWriter(new BufferedWriter(new FileWriter(sports, true)),true);
          System.out.println("File Opening");
        }
        catch (IOException b)
        {
          System.out.println("Problem opening File");
        }
      }      
      else if(names.equals("Chaplancy"))
      {     
        try
        {
          out=new PrintWriter(new BufferedWriter(new FileWriter(chaplency, true)),true);
          System.out.println("File Opening");
        }
        catch (IOException b)
        {
          System.out.println("Problem opening File");
        }
      }
      
      else   if(names.equals("Clubs"))
      {     
        try
        {
          out=new PrintWriter(new BufferedWriter(new FileWriter(clubs, true)),true);
          System.out.println("File Opening");
        }
        catch (IOException b)
        {
          System.out.println("Problem opening File");
        }
      }
      else   if(names.equals("Civies"))
      {     
        try
          
        {
          out=new PrintWriter(new BufferedWriter(new FileWriter(civies, true)),true);
          System.out.println("File Opening");
        }
        catch (IOException b)
        {
          System.out.println("Problem opening File");
        }
      }
      
      else if(names.equals("Other"))
      {     
        try
        {
          out=new PrintWriter(new BufferedWriter(new FileWriter(other, true)),true);
          System.out.println("File Opening");
        }        
        catch (IOException b)
        {
          System.out.println("Problem opening File");
        }
      }
      
      else   if(names.equals("P.A.DAY"))
      {     
        try
        {
          out=new PrintWriter(new BufferedWriter(new FileWriter(paday, true)),true);
          System.out.println("File Opening");
        }
        catch (IOException b)
        {
          System.out.println("Problem opening File");
        }
      }
      else  if(names.equals("Select one"))
      {
        menu.setBorder(BorderFactory.createLineBorder(Color.red,2));
      }
    }
    
    if (e.getSource()==enter2)
    {
      area2=area.getText();
      out.println(area.getText());
      System.out.println(check);
    }
    if (e.getSource()==old)
    {
      System.out.print("old");
      panel3.setVisible(false);         
      panel5.setVisible(true);         
    }
    if(e.getSource()==select2)
    {  System.out.println("working");
      names=(String)menu2.getSelectedItem();
    
      menu2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      if(names.equals("Sports"))
      {          
        System.out.println("working");
        try
        {

            FileReader fileReader = 
                new FileReader(names  );

      BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

          System.out.println("File Opening");
        
  }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                names + "'");                
        

    }
    }
  }
}
  




