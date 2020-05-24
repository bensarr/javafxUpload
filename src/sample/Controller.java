package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lblError;
    @FXML
    private ImageView imgV;
    private FileChooser fileChooser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //init Error Label
        lblError.setVisible(false);
        lblError.setText("");

        //initialize imageView from Web URL
        Image image=new Image("https://www.mesinspirationsculinaires.com/wp-content/uploads/2016/07/aid-moubarak-2012.jpeg");
        imgV.setImage(image);

        //initialize fileChooser extentions
        fileChooser= new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    public void change(ActionEvent actionEvent) throws MalformedURLException {
        fileChooser.setTitle("Change Picture");
        File file= fileChooser.showOpenDialog(null);
        if(file!=null)
        {
            String url=file.toURI().toURL().toString();
            imgV.setImage(new Image(url));
        }
        else
        {
            lblError.setVisible(true);
            lblError.setText("Image Incorrect");
        }
    }
}
