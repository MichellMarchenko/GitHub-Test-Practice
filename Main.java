

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label("Clinic Appointment Booking System");

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("Patient First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Patient Last Name");

        Label resultLabel = new Label();

        Button createButton = new Button("Create Patient");

        createButton.setOnAction(event -> {

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();

            Patient patient = new Patient(
                    1,
                    firstName,
                    lastName,
                    "5195551234",
                    "Windsor, Ontario"
            );

            Doctor doctor = new Doctor(
                    1,
                    "Dr. Smith",
                    "Family Medicine"
            );

            Appointment appointment = new Appointment(
                    patient,
                    doctor,
                    "2026-10-05",
                    "10:00 AM"
            );

            resultLabel.setText(
                    "Patient: "
                            + patient.getFirstName()
                            + " "
                            + patient.getLastName()
                            + "\nDoctor: "
                            + doctor.getName()
                            + "\nSpecialty: "
                            + doctor.getSpecialty()
                            + "\nAppointment: "
                            + appointment.getDate()
                            + " "
                            + appointment.getTime()
            );
        });

        VBox layout = new VBox(
                10,
                title,
                firstNameField,
                lastNameField,
                createButton,
                resultLabel
        );

        Scene scene = new Scene(layout, 450, 300);

        stage.setTitle("Clinic Appointment System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
