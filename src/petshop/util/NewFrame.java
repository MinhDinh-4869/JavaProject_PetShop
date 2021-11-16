package petshop.util;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import petshop.pets.classes.*;

public class NewFrame {
    public static void CreateFrameToAddPet()
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
           options.add(add);
           options.add(cancel);

           input_frame.getContentPane().add(BorderLayout.NORTH, info_session);
           input_frame.getContentPane().add(BorderLayout.SOUTH, options);

           input_frame.setVisible(true);
    }

    public static void CreateFrameToChoosePetToAdd()
    {
           JFrame choose_pet = new JFrame("Add Pet");
           //ActionListener exit = e-> choose_pet.dispose();
           choose_pet.setSize(200, 200);

           JPanel pet_list = new JPanel();
           JButton dog = new JButton("Dog");

           ActionListener dog_chose = e -> {
                  choose_pet.dispose();
                  Dog new_dog = new Dog();
                  new_dog.CreateFrameToGetInfo();
                  //return new_dog;
           };
           pet_list.add(dog);
           dog.addActionListener(dog_chose);
           choose_pet.getContentPane().add(BorderLayout.CENTER, pet_list);
           choose_pet.setVisible(true);
    }
}
