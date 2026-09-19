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
    
    void listarVeic
