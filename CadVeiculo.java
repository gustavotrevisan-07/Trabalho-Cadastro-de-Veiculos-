import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

List<Veiculo> veiculos = new ArrayList<>();

void main(){
    String menu = """
            ==== Cadastro de Veículos====
            Selecione uma opção:
            1 - Cadastrar veículo
            2 - Listar veículos
            3 - Consultar veículo
            0 - Sair
            """;
        int opcao = -1;
        while(opcao != 0){
            IO.println (menu);
            opcao = new Input().readInt("Digite a opção desejada: ");
            switch(opcao){
                case 1 -> cadastrarVeiculo();
                    break;
                case 2 ->
                    listarVeiculos();
                    break;
                case 3 ->
                    consultarVeiculo();
                    break;
                case 0 ->
                    IO.println("Saindo do programa...");
                    break;
                default ->
                    IO.println("Opção inválida, tente novamente.");
            }  
        }

    }
void cadastrarVeiculo(){
        String marca = IO.readln("Digite a marca: ");
        marca = marca.trim();
        String modelo = IO.readln("Digite o modelo: ");
        modelo = modelo.trim();

        int ano;
        while(true){
            ano = new Input().readInt("Digite o ano: ");
            int anoAtual = LocalDate.now().getYear();
            if(ano >= 1900 && <= anoAtual + 1){
                break;
            }
            IO.println("Ano inválido, tente novamente.");
        }
        String placa = IO.readln("Digite a placa: ");
        placa = placa.trim();
        if (buscarVeiculo(placa) != null){
            IO.println("Já existe um veículo cadastrado com essa placa.");
            return;
        }
        Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
        veiculos.add(veiculo);
        IO.println("Veículo cadastrado com sucesso!");
    }

void listarVeiculos() {
    IO.println("Lista de Veículos:");
    if (veiculos.isEmpty())
        IO.println("Nenhum veiculo cadastrado.");
        return;
    }
    for (int i = 0; i < veiculos.size(); i++){
        Veiculo veiculo = veiculos.get(i);
        IO.println((i + 1 ) + " - Marca: " + veiculo.marca + ", Modelo: " + veiculo.modelo + ", Ano: " + veiculo.ano + ", Placa: " + veiculo.placa);

    }
void consultarVeiculo() { 
    String placa = IO.realn("Digite a placa do veículo: ");
    placa = placa.trim();
    Veiculo veiculo = buscarVeiculo(placa);
    if  (veiculo != null){
        IO.println("Veículo encontrado:");
        IO.println("Marca: " + veiculo.marca);
        IO.println("Modelo: " + veiculo.modelo);
        IO.println("Ano: " + veiculo.ano);
        IO.println("Placa: " + veiculo.placa);
    } else {
        IO.println("Veículo não encontrado.");
    }
}

Veiculo buscarVeiculo(String placa){
    for (Veiculo veiculo : veiculos){
        if (veiculo.placa.equalsIgnoreCase(placa)){
            return veiculo;
        }
    }
    return null;
}