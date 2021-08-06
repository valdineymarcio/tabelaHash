package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TabelaHash<Integer> hash;
        int quantidadeDeLacos = sc.nextInt();

        for (int i = 1; i <= quantidadeDeLacos; i++) {

            int tamanho = sc.nextInt();
            int num_elementos = sc.nextInt();

            hash = new TabelaHash(tamanho);
            for (int j = 0; j < num_elementos; j++) {
                int chave = sc.nextInt();
                hash.insere(chave);
            }
            hash.imprime();
            if (i != quantidadeDeLacos) System.out.println();
        }
    }

    public static class ListaEncadeada<T> {
        private No<T> cabeca;

        public void insere(T elemento) {
            if (cabeca == null) {
                cabeca = new No(elemento);
            } else {
                No<T> aux = cabeca;
                while (aux.proximo != null) {
                    aux = aux.proximo;
                }
                aux.proximo = new No(elemento);
            }
        }

        public void imprime() {
            No<T> auxiliar = cabeca;
            while (auxiliar != null) {
                System.out.print(auxiliar.elemento + " -> ");

                auxiliar = auxiliar.proximo;
            }
            System.out.println("\\");
        }
    }

    public static class No<T> {
        T elemento;
        No<T> proximo;

        public No(T elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    public static class TabelaHash<T> {

        private ListaEncadeada<T>[] hash;

        public TabelaHash(int tamanho) {
            hash = new ListaEncadeada[tamanho];
            for (int i = 0; i < hash.length; i++) {
                hash[i] = new ListaEncadeada<T>();
            }
        }

        public void insere(T chave) {
            int num = chave.hashCode() % hash.length;
            hash[num].insere(chave);
        }

        public void imprime() {
            for (int i = 0; i < hash.length; i++) {
                System.out.print(i + " -> ");
                hash[i].imprime();
            }
        }
    }
}
