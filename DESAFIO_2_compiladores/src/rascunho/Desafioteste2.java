/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rascunho;

import classes.Chaves;
import classes.Colchetes;
import classes.Parenteses;
import classes.Simbolos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author BRUNOSILVA
 */
public class Desafioteste2 {

    /*
             
        "(" = empilha a
        "[" = empilha b
        "{" = empilha c
        ")" ou  "]" ou "}" = desempilha e verifica se o desempilhado é igual ao posição atual.
        Se sim, é válido.
        Será inválido se: 
        -a pilha estiver vazia e precisar desempilhar
        -acabar a varredura e a pilha estiver cheia
        
     */
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     *
     */
    public static void main(String[] args) throws IOException {
        Simbolos s = new Simbolos();
        Parenteses parents = new Parenteses();
        Colchetes colchets = new Colchetes();
        Chaves chavs = new Chaves();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> resp = new ArrayList<>();

        int cont = 0;

        //for (String arg : args) {
        String caminho = "prog.txt";
        //Lendo arquivo texto pela linha de comando
        if (!new File(caminho).exists()) {
            new File(caminho).createNewFile();
            //System.out.println("O arquivo não existe e foi criado");

        } else {
            try (Scanner reader = new Scanner(new FileReader(caminho))) {
                String line;
                while (reader.hasNext()) {
                    line = reader.next();
                    resp.add(line);
                    cont++;
                }
            } catch (IOException e) {
                e.getMessage();
            } catch (Exception e) {
                e.getMessage();
            }
        }

        //Agora verifica palavra por palavra do arquivo texto se é válida ou não!
        boolean invalido = false;
        for (String linha : resp) {
            Stack<String> pilha = new Stack<>();

            String alf = "";
            for (int i = 0; i < linha.length(); i++) {
                String item = Character.toString(linha.charAt(i));
                if (item.equals(parents.getAbre()) || item.equals(parents.getFecha())) {
                    alf += "a";
                } else if (item.equals(colchets.getAbre()) || item.equals(colchets.getFecha())) {
                    alf += "b";
                } else if (item.equals(chavs.getAbre()) || item.equals(chavs.getFecha())) {
                    alf += "c";
                }
            }

            if (s.getFechado().contains(linha.charAt(0))
                    || s.getAberto().contains(linha.charAt(linha.length() - 1))) {
                //System.out.println(linha);
                invalido = true;
                linha += " - Palavra inválida - começa fechando ou termina abrindo";

            } else {
                invalido = false;
                for (int i = 0; i < linha.length(); i++) {
                    String item = Character.toString(linha.charAt(i));
                    String aux;
                    String alfPos;

                    if (item.equals(parents.getAbre())) {
                        pilha.push("a");
                    } else if (item.equals(colchets.getAbre())) {
                        pilha.push("b");
                    } else if (item.equals(chavs.getAbre())) {
                        pilha.push("c");
                    } else {
                        if (!pilha.empty()) {
                            aux = pilha.pop();
                            alfPos = Character.toString(alf.charAt(i));

                            if (!aux.equals(alfPos)) {
                                //System.out.println("Palavra inválida 2");
                                invalido = true;
                                linha += " - Palavra inválida 2";
                                linha += " - Caractere desempilhado diferente do caractere da posição esperada";
                                //sc.nextLine();
                                break;
                            }
                        } else if (pilha.empty() && linha.length() - i > 0) {
                            //System.out.println("Pilha vazia e ainda falta desempilhar");
                            // System.out.println("Palavra inválida 3");
                            invalido = true;
                            linha += " - Pilha vazia e ainda falta desempilhar - Palavra inválida 3";
                            break;
                        } else {
                            //System.out.println("Palavra aceita");
                            linha += " - Palavra aceita1";
                        }
                    }
                }

                if (pilha.empty() && !invalido) {
                    //System.out.println("Palavra aceita");
                    linha += " - Palavra aceita2";
                } 
                /*
                else {
                    //System.out.println("Palavra inválida 4");
                    linha += " - Pilha cheia e acabou a leitura da palavra";
                }
                */

                System.out.println(linha);

            }
        }

        //}
    }
}
/*
 try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
                    String line;
                    while ((line=reader.readLine()) != null) {
                        resp[cont] = line;
                        cont++;
                    }
                } catch (IOException e) {
                    e.getMessage();
                } catch (Exception e) {
                    e.getMessage();
                }
 */
