package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.Periodo;
import uv.fei.tutorias.domain.ProgramaEducativo;
import uv.fei.tutorias.domain.SesionTutoria;
import uv.fei.tutorias.domain.Usuario;
import uv.mensajes.Alertas;

public class RegistrarFechasDeSesionDeTutoriaController implements Initializable{

    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;
    @FXML
    private AnchorPane panelFechaSesionTutoria;
    @FXML
    private TextField txtPeriodoActivo;
    @FXML
    private Text lblPrimeraTutoria;
    @FXML
    private Text lblSegundaTutoria;
    @FXML
    private Text lblTerceraTutoria;

    Alertas alertas = new Alertas();

    private Usuario usuarioActivo;
    private ProgramaEducativo programaEducativoActivo;
    
    public void recibirParametros(Usuario usuarioRecibido, ProgramaEducativo programaEducativo) throws SQLException{
        usuarioActivo = usuarioRecibido;
        programaEducativoActivo = programaEducativo;
    }

    @FXML
    void enviar(ActionEvent event) throws SQLException{
        registrarSesion(dpPrimeraSesion, lblPrimeraTutoria);
        registrarSesion(dpSegundaSesion, lblSegundaTutoria);
        registrarSesion(dpTerceraSesion, lblTerceraTutoria);
    }

    public void registrarSesion(DatePicker fechaTutoria, Text numeroTutoria) throws SQLException {
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodo = new Periodo();
        periodo = periodoDao.consultarPeriodoActivo();
        int idPeriodo = periodo.getIdPeriodo();
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        nuevaSesionTutoria.setFechaTutoria(fecha);
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getText());
        nuevaSesionTutoria.setIdPeriodo(idPeriodo);
        try{
            SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
        }catch(SQLException e){
            alertas.mostrarAlertaErrorConexionDB();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo periodo = new Periodo();
        try {
            periodo = periodoDao.consultarPeriodoActivo();
            txtPeriodoActivo.setText(periodo.getFechaInicio()+ " - " + periodo.getFechaFin());
            txtPeriodoActivo.setEditable(false);
            
        } catch (SQLException ex) {
           alertas.mostrarAlertaErrorConexionDB();
        }
    }

    @FXML
    private void cancelarRegistro(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}