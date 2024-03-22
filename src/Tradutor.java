import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tradutor {
    // essa primeira linha é obrigatória para o logisim pode ler o arquivo
    // resultante
    String binario = "v2.0 raw \n";
    int line;

    public void leitura() {
        // lendo o arquivo de entrada de dados, são as instruções do usuário
        String arquivoCSV = "prompt.csv";
        try {
            File arquivo = new File(arquivoCSV);
            Scanner scanner = new Scanner(arquivo);
            this.line = 0;
            // lê linha por linha
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(" ");
                this.line++;

                // verifica se alinha é vazia
                if (linha.isEmpty()) {
                    continue;
                }

                // verificando qual é a opção. ex: se opbção fo soma, o binário recebe 0000 que
                // é o código logisim para a soma
                switch (dados[0]) {
                    case "soma": // soma
                        this.binario += "0";
                        break;
                    case "dimi": // subtração
                        this.binario += "1";
                        break;
                    case "vezes": // multiplicação
                        this.binario += "2";
                        break;
                    case "carregar": // pegar da memoria
                        this.binario += "3";
                        break;
                    case "guardeMen": // guarda na memoria
                        this.binario += "4";
                        break;
                    case "coloqueInt": // colocar um int no resgistrador
                        this.binario += "6";
                        break;
                    case "maiorQ": //
                        this.binario += "7";
                        break;
                    case "somaInt": // soma com inteiro
                        this.binario += "8";
                        break;
                    case "salte": // salte para
                        this.binario += "9000";
                        break;
                    default:
                        System.out.println("Instrução inválida [linha: " + line + "]");
                        this.line = -1;
                        return;
                }
                if (dados[0] == "salte") {
                    int valor = Integer.parseInt(dados[1]);
                    valor = valor * 4;

                } else if (dados[0] == "maiorQ") {
                    // verifica quais registradores estamos usando
                    for (int i = 1; i < dados.length-1; i++) {
                        switch (dados[i]) {
                            case "{0}": // {} registrador sem é inteiro
                                this.binario += "0";
                                break;
                            case "0":
                                this.binario += "0";
                                break;
                            case "{1}":
                                this.binario += "1";
                                break;
                            case "1":
                                this.binario += "1";
                                break;
                            case "{2}":
                                this.binario += "2";
                                break;
                            case "2":
                                this.binario += "2";
                                break;
                            case "{3}":
                                this.binario += "3";
                                break;
                            case "3":
                                this.binario += "3";
                                break;
                            case "{4}":
                                this.binario += "4";
                                break;
                            case "4":
                                this.binario += "4";
                                break;
                            case "{5}":
                                this.binario += "5";
                                break;
                            case "5":
                                this.binario += "5";
                                break;
                            case "{6}":
                                this.binario += "6";
                                break;
                            case "6":
                                this.binario += "6";
                                break;
                            case "{7}":
                                this.binario += "7";
                                break;
                            case "7":
                                this.binario += "7";
                                break;
                            case "{8}":
                                this.binario += "8";
                                break;
                            case "8":
                                this.binario += "8";
                                break;
                            case "{9}":
                                this.binario += "9";
                                break;
                            case "9":
                                this.binario += "9";
                                break;
                            case "{10}":
                                this.binario += "a";
                                break;
                            case "10":
                                this.binario += "a";
                                break;
                            case "{11}":
                                this.binario += "b";
                                break;
                            case "11":
                                this.binario += "b";
                                break;
                            case "{12}":
                                this.binario += "c";
                                break;
                            case "12":
                                this.binario += "c";
                                break;
                            case "{13}":
                                this.binario += "d";
                                break;
                            case "13":
                                this.binario += "d";
                                break;
                            case "{14}":
                                this.binario += "e";
                                break;
                            case "14":
                                this.binario += "e";
                                break;
                            case "{15}":
                                this.binario += "f";
                                break;
                            case "15":
                                this.binario += "f";
                                break;

                            default:
                                System.out.println("Registrador inválido [linha: " + line + "]");
                                this.line = -1;
                                return;
                        }
                    }
                    // se não usarmos todos os espaços, completamos com 0
                            this.binario += "0";
                            int valor = Integer.parseInt(dados[4]);
                            valor = valor * 4;
                            

                        
                } else {
                    // verifica quais registradores estamos usando
                    for (int i = 1; i < dados.length; i++) {
                        switch (dados[i]) {
                            case "{0}": // {} registrador sem é inteiro
                                this.binario += "0";
                                break;
                            case "0":
                                this.binario += "0";
                                break;
                            case "{1}":
                                this.binario += "1";
                                break;
                            case "1":
                                this.binario += "1";
                                break;
                            case "{2}":
                                this.binario += "2";
                                break;
                            case "2":
                                this.binario += "2";
                                break;
                            case "{3}":
                                this.binario += "3";
                                break;
                            case "3":
                                this.binario += "3";
                                break;
                            case "{4}":
                                this.binario += "4";
                                break;
                            case "4":
                                this.binario += "4";
                                break;
                            case "{5}":
                                this.binario += "5";
                                break;
                            case "5":
                                this.binario += "5";
                                break;
                            case "{6}":
                                this.binario += "6";
                                break;
                            case "6":
                                this.binario += "6";
                                break;
                            case "{7}":
                                this.binario += "7";
                                break;
                            case "7":
                                this.binario += "7";
                                break;
                            case "{8}":
                                this.binario += "8";
                                break;
                            case "8":
                                this.binario += "8";
                                break;
                            case "{9}":
                                this.binario += "9";
                                break;
                            case "9":
                                this.binario += "9";
                                break;
                            case "{10}":
                                this.binario += "a";
                                break;
                            case "10":
                                this.binario += "a";
                                break;
                            case "{11}":
                                this.binario += "b";
                                break;
                            case "11":
                                this.binario += "b";
                                break;
                            case "{12}":
                                this.binario += "c";
                                break;
                            case "12":
                                this.binario += "c";
                                break;
                            case "{13}":
                                this.binario += "d";
                                break;
                            case "13":
                                this.binario += "d";
                                break;
                            case "{14}":
                                this.binario += "e";
                                break;
                            case "14":
                                this.binario += "e";
                                break;
                            case "{15}":
                                this.binario += "f";
                                break;
                            case "15":
                                this.binario += "f";
                                break;

                            default:
                                System.out.println("Registrador inválido [linha: " + line + "]");
                                this.line = -1;
                                return;
                        }
                    }
                    // se não usarmos todos os espaços, completamos com 0
                    if (this.binario.length() != 8) {
                        for (int i = 0; i != 4 - dados.length; i++) {
                            this.binario += "0";
                        }
                    }
                }

                this.binario += " "; // damos um espaço para a proxima instrução
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
            this.line = -1;
            return;
        }
        if (line > 0) {
            escreverBinario();
        }
    }

    public void escreverBinario() {
        String arquivoBinarioCSV = "binario.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoBinarioCSV))) {
            // Escreve o conteúdo do atributo binario no arquivo CSV
            writer.println(this.binario);
            System.out.println("Conteúdo binário foi escrito com sucesso no arquivo binario.csv.");
            System.out.println(this.binario);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo binario.csv: " + e.getMessage());
        }
    }
}
