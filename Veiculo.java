import java.time.LocalDate;

public class Veiculo {

    String marca;
    String modelo;
    int ano;
    String placa;

    Veiculo() {
        this("Marca", "Modelo",
                LocalDate.now().getYear(), "XXX-0000");
    }

    Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }
}