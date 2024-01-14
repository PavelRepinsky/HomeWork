package com.company.Homework28_12_2023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SecondTask {
    public static String readContent(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();
        String input;

        while ((input = buffer.readLine()) != null)
            content.append(input);
        buffer.close();

        return content.toString();
    }

    public static void main(String[] args) throws Exception{
        Scanner console = new Scanner(System.in);
        int count = 0;
        while (true) {
            if (count == 0) {
            System.out.println("Введите URL");}
            else {
                System.out.println("Введите корректный URL в формате http(s)://<domain Adress>.ru(com), к примеру - https://www.google.ru/");
            }
            String url = console.nextLine();
            count++;
        {try{String site = SecondTask.readContent(url);
            System.out.println(site);
        break;}
        catch (MalformedURLException e) {
            System.out.println("Что-то пошло не так, проблема состоит в следующем: " + e.getMessage());
                }
                catch (UnknownHostException e) {
                    System.out.println("Что-то пошло не так, возможно, ошибка в адресе сервера или в пути к ресурсу на сервере");
                }
            }
        }
    }
}
