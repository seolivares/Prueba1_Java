package entidad;

public class Paciente {
    //ATRIBUTOS
    private String dni;
    private String nombre;
    private int edad;
    private char sexo;
    private int[] pesoMensual;

    public Paciente(String dni, String nombre, int edad, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.pesoMensual = new int[12];

        for (int i=0;i<pesoMensual.length;i++){
            pesoMensual[i] = (int) (Math.random()*(250-70+1)+70) ;//random entre 70 a 250
        }
    }

    public Paciente() {

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int[] getPesoMensual() {
        return pesoMensual;
    }

    public void setPesoMensual(int[] pesoMensual) {
        this.pesoMensual = pesoMensual;
    }

    public int menorPesoMensual() {
        int contMes = 0;

        int pesoMenor = 250;

        for(int i=0;i<pesoMensual.length;i++) {
            if(pesoMensual[i] < pesoMenor){
                pesoMenor = pesoMensual[i];
                contMes = i+1;
            }
        }

        return contMes;
    }

    public double indiceMasaCorporal(int mesX, double estPaciente) {
        double indiceMes = 0;

        indiceMes = pesoMensual[mesX-1] / (estPaciente*estPaciente);

        return indiceMes;
    }

    public int[] menosDeXKilos(int Xkilos){
        int contador = 0;

        // Contar cuántos meses para nuevo arreglo
        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < Xkilos) {
                contador++;
            }
        }

        if (contador == 0) {
            return null;
        }else{
            int[] mesPesaMenos = new int[contador];
            int indice = 0;

            for (int i = 0; i < pesoMensual.length; i++) {
                if (pesoMensual[i] < Xkilos) {
                    mesPesaMenos[indice] = i + 1;
                    indice++;
                }
            }

            return mesPesaMenos;
        }
    }

    public String pesoMesX(double indiceMC) {
        String condicion = "";

        if(indiceMC >= 15 && indiceMC < 20){
            condicion = "Normal";
        }

        if(indiceMC >= 20 && indiceMC < 28){
            condicion = "Sobrepeso";
        }

        if(indiceMC >= 28){
            condicion = "Obeso";
        }

        return condicion;
    }
}
