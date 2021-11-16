package petshop.pets.classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Random;

public class PetsAb {
    protected String[] mood = {"Happy", "Hungry", "Thirsty", "Sick", "Healthy"};
    protected String name;
    protected String age;
    protected String price;
    protected boolean isAdded = false;
    protected String location;
    protected String ID;
    protected String generate_ID()
    {
        StringBuilder ID = new StringBuilder();
        for(int i=0; i<5; i++)
        {
            Random rand = new Random();
            int id_element = rand.nextInt(10);
            ID.append(id_element);
        }
        return ID.toString();
    }
    public String generateStatus()
    {
        Random rand = new Random();
        int m = rand.nextInt(5);
        return mood[m];
    }
    public void CreateFrameToGetInfo()
    {
        JFrame input_frame = new JFrame("Add Pet");
        input_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        input_frame.setSize(200, 200);

        JPanel info_session = new JPanel();
        JLabel pet_name = new JLabel("Pet Name: ");
        JTextField tf_pet_name = new JTextField();
        JLabel pet_age = new JLabel("Pet Age: ");
        JTextField tf_pet_age = new JTextField();
        JLabel pet_price = new JLabel("Price: ");
        JTextField tf_pet_price = new JTextField();
        info_session.setLayout(new GridLayout(3,2));
        info_session.add(pet_name);
        info_session.add(tf_pet_name);
        info_session.add(pet_age);
        info_session.add(tf_pet_age);
        info_session.add(pet_price);
        info_session.add(tf_pet_price);

        JPanel options = new JPanel();
        JButton add = new JButton("Add");
        JButton cancel = new JButton("Cancel");
        JButton print = new JButton("Print");
        options.add(add);
        options.add(cancel);
        options.add(print);

        input_frame.getContentPane().add(BorderLayout.NORTH, info_session);
        input_frame.getContentPane().add(BorderLayout.SOUTH, options);

        ActionListener exit = e-> {
            this.name = tf_pet_name.getText();
            this.age = tf_pet_age.getText();
            this.price = tf_pet_price.getText();
            this.isAdded = true;
            save_info();
            input_frame.dispose();
        };
        ActionListener exit_1 = e ->
        {
            //this.isAdded = false;
            input_frame.dispose();
        };
        ActionListener pr = e->System.out.println(this.isAdded);
        print.addActionListener(pr);
        add.addActionListener(exit);
        cancel.addActionListener(exit_1);
        input_frame.setVisible(true);
    }

    public void save_info()
    {
        try{
            String path_to_info = this.location + this.ID + ".txt";
            FileWriter file_handle = new FileWriter(path_to_info);
            file_handle.write(this.name + "," + this.age + "," + this.price);
            file_handle.close();
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong");
        }

    }
    public boolean GetToKnowIsAdded()
    {
        return this.isAdded;
    }
}
