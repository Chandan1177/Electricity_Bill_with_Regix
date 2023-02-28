package com.example.electricity_bill;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationControllar {
    public TextField name_txt,add_txt,city_txt,state_txt,email_txt,ph_txt;
    String name,address,city,state,email,phone;

    public void onnext(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String value;
       if( validate_name(value=name_txt.getText())){name=value; value="";
           if( validate_add(value=add_txt.getText())){address=value; value="";
               if( validate_city(value=city_txt.getText())){city=value; value="";
                   if( validate_state(value=state_txt.getText())){state=value; value="";
                       if( validate_email(value=email_txt.getText())){email=value; value="";
                           if( validate_ph(value=ph_txt.getText())){phone=value; value="";
                               String mn=new Quries().register(name,address,city,state,email,phone);
                               conformationBox(mn);
                           }
                           else{alertBox("phone number is not validate","Ok","Cancel");}
                       }else{alertBox("email is not validate","Ok","Cancel");}
                   }else{alertBox("state not validate","Ok","Cancel");}
               }else{alertBox("city not validate","Ok","Cancel");}
           }else{alertBox("address not validate","Ok","Cancel");}}
       else{alertBox("name not validate","Ok","Cancel");}



    }

    public void oncencel(ActionEvent actionEvent) {
    }

    public boolean validate_name(String st){
        String str="^[a-zA-Z][a-zA-Z/ _]{3,}";
        Pattern pattern=Pattern.compile(str);
        Matcher matcher=pattern.matcher(st);
        return matcher.matches();
    }
    public boolean validate_add(String st){
        String str="^[a-zA-Z][a-zA-Z/ ]{3,}";
        Pattern pattern=Pattern.compile(str);
        Matcher matcher=pattern.matcher(st);
        return matcher.matches();
    }
    public boolean validate_city(String st){
        String str="[a-zA-Z][a-zA-Z]{3,}";
        Pattern pattern=Pattern.compile(str);
        Matcher matcher=pattern.matcher(st);
        return matcher.matches();
    }
    public boolean validate_state(String st){
        String str="^[a-zA-Z][a-zA-Z]{3,}";
        Pattern pattern=Pattern.compile(str);
        Matcher matcher=pattern.matcher(st);
        return matcher.matches();
    }
    public boolean validate_email(String st){
        String str="^[a-zA-Z\\d_+&*-]+(?:\\.[\\w_+&*-]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,}$";
        Pattern pattern=Pattern.compile(str);
        Matcher matcher=pattern.matcher(st);
        return matcher.matches();
    }
    public boolean validate_ph(String st){
        String str="^[1-9]+\\d{9}$";
        Pattern pattern=Pattern.compile(str);
        Matcher matcher=pattern.matcher(st);
        return matcher.matches();
    }
    public void alertBox(String msg,String btn1,String btn2){
        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Alert");
        window.setMinWidth(300);
        window.setMinHeight(150);
        Label label=new Label(msg);
        Button bt1=new Button(btn1);
        Button bt2=new Button(btn2);
        bt1.setOnAction(e -> window.close());
        bt2.setOnAction(e -> {
            new HelloApplication().s.close();
            window.close();
        });
        VBox box=new VBox(10);
        HBox box1=new HBox(2);
        box1.getChildren().addAll(bt1,bt2);
        box1.setAlignment(Pos.CENTER);
        box.getChildren().addAll(label,box1);
        box.setAlignment(Pos.CENTER);
        Scene scene=new Scene(box);
        window.setScene(scene);
        window.showAndWait();
    }

    public static void conformationBox(String msg){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Message:");
        window.setMinWidth(200);
        window.setMinHeight(150);
        Label label=new Label(msg);
        Button ok=new Button("ok");
        ok.setOnAction(e -> window.close());
        VBox box=new VBox(10);
        box.getChildren().addAll(label,ok);
        box.setAlignment(Pos.CENTER);
        Scene scene=new Scene(box);
        window.setScene(scene);
        window.showAndWait();
    }
}
