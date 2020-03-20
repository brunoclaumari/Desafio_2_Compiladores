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

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author BRUNOSILVA
 */
public class DesafioRascunho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();

        Simbolos s = new Simbolos();
        Parenteses parents = new Parenteses();
        Colchetes colchets = new Colchetes();
        Chaves chavs = new Chaves();
        Scanner sc = new Scanner(System.in);

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
        String testa = "{[[(()[{}]]]})";//essa é inválida
        String alf = "";
        for (int i = 0; i < testa.length(); i++) {
            String item = Character.toString(testa.charAt(i));
            if (item.equals(parents.getAbre()) || item.equals(parents.getFecha())) {
                alf += "a";
            } else if (item.equals(colchets.getAbre()) || item.equals(colchets.getFecha())) {
                alf += "b";
            } else if (item.equals(chavs.getAbre()) || item.equals(chavs.getFecha())) {
                alf += "c";
            }
        }

        if (s.getFechado().contains(testa.charAt(0))
                || s.getAberto().contains(testa.charAt(testa.length() - 1))) {
            System.out.println(testa + ": Palavra inválida 1");

        } else {
            for (int i = 0; i < testa.length(); i++) {
                String item = Character.toString(testa.charAt(i));
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
                            System.out.println("Palavra inválida 2");
                            sc.nextLine();
                            break;
                        }
                    } else if (pilha.empty() && testa.length() - i > 0) {
                        System.out.println("Pilha vazia e ainda falta desempilhar");
                        System.out.println("Palavra inválida 3");
                        break;
                    } else {
                        System.out.println("Palavra aceita");
                    }
                }
            }
            if (pilha.empty()) {
                System.out.println("Palavra aceita");
            } else {
                System.out.println("Palavra inválida 4");
            }

        }
    }
}
/*
 Parenteses par = new Parenteses();
        Colchetes colc = new Colchetes();
        Chaves ch = new Chaves();
 */

 /*
String item=Character.toString(testa.charAt(i));
                String aux="";
                
                if(s.getAberto().contains(testa.charAt(i))){
                    pilha.push(item);
                }
                else{
                    aux=pilha.pop();
                    if(aux instanceof pilha.peek().g)
                    
                }
 */

 /*
 List<String> parents = Arrays.asList("(", ")");
        List<String> conchets = Arrays.asList("[", "]");
        List<String> chavs = Arrays.asList("{", "}");
 */
