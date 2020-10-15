package br.com.zup.estrelas.cidades.programaPrincipal;

import java.util.Calendar;
import java.util.Scanner;

import br.com.zup.estrelas.cidades.DAO.CidadesDAO;
import br.com.zup.estrelas.cidades.POJO.CidadePOJO;

public class ProgramaPrincipal {

	private static final String MENU = "\t=========Cadastro de cidades=========\n"
			+ "\n\t====digite uma das opções abaixo:====\n" + "\t      1 -> cadastrar nova cidade\n"
			+ "\t      0 -> sair do programa\n";

	public static void main(String[] args) throws Exception {

		Scanner teclado = new Scanner(System.in);
		Calendar data = Calendar.getInstance();
		CidadesDAO conexao = new CidadesDAO();
		CidadePOJO cidade = new CidadePOJO();

		int opcaoMenu;

		do {
			System.out.println(MENU);
			opcaoMenu = teclado.nextInt();

			switch (opcaoMenu) {
			case 1:
//				colher o nome da cidade
				System.out.println("Digite o nome da cidade:");
				cidade.setNome(teclado.next());

//				colher o cep da cidade
				System.out.println("Digite o cep da cidade:");
				boolean ok = false;
				while (ok) {
					try {
						Integer cep = teclado.nextInt();
						cidade.setCep(cep.toString());
						ok = true;

					} catch (Exception e) {
						System.err.println("Digite apenas os numeros do cep da cidade");
						System.err.println(e.getMessage());
					}
					;
				}

				// numero de habitantes da cidade
				System.out.println("Digite o numero de habitantes:");

				ok = false;
				while (ok) {
					try {
						Integer numHabitantes = teclado.nextInt();
						cidade.setNumeroHabitantes(numHabitantes);
						ok = true;

					} catch (Exception e) {
						System.err.println("Digite apenas o número INTEIRO de habitantes");
						System.err.println(e.getMessage());
					}
					;
				}

				// cidade é capital
				int capitalBoolean;
				do {
					System.out.println("Se a cidade for capital digite 1, ou digite zero caso contrário");
					capitalBoolean = teclado.nextInt();

					try {
						if (capitalBoolean == 1) {
							cidade.setEhCapital(true);
						}
					} catch (Exception e) {
						System.err.println("Digite apenas 1 se a cidade for capital, e 0 caso contrário");
						System.err.println(e.getMessage());
					}

				} while ((capitalBoolean < 0) || (capitalBoolean > 1));

				// sigla do estado
				System.out.println("Digite a sigla do estado ao qual a cidade pertence:");
				teclado.next();
				cidade.setEstado(teclado.next());

				// renda percapta
				System.out.println("Digite a renda per capta da cidade:");
				ok = false;
				while (ok) {
					try {
						cidade.setNumeroHabitantes(teclado.nextFloat());
						ok = true;

					} catch (Exception e) {
						System.err.println("Digite apenas o número INTEIRO de habitantes");
						System.err.println(e.getMessage());
					}
				}

				// data de fundação da cidade
				
				ok = false;
				while (ok) {
					try {
						System.out.println("Digite o ano de fundação da cidade:");
						int ano = teclado.nextInt();

						System.out.println("Digite o mês de fundação da cidade:");
						int mes = teclado.nextInt();

						System.out.println("Digite o dia de fundação da cidade:");
						int dia = teclado.nextInt();

						data.set(ano, mes, dia);

						cidade.setData(data.getCalendarType());
					} catch (Exception e) {
						System.err.println("use apenas números para reperesentar a data de fundação,"
								+ " e digite conforme forem sendo pedidos");
						System.err.println(e.getMessage());
					}
				}

				conexao.insereCidade(cidade);

				break;

			case 0:
				System.out.println("Obrigado!");

				break;

			default:
				break;
			}

		} while (opcaoMenu != 0);

		teclado.close();
	}

}
