package com.epam.mjc.io;

import com.sun.source.tree.ArrayAccessTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){
            String line = bufferedReader.readLine();
            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();
            StringBuilder email = new StringBuilder();
            StringBuilder phone = new StringBuilder();
            for(int i = 0;i<4;i++){
                if(i==0){
                    name.append(line);
                }else if(i==1){
                    age.append(bufferedReader.readLine());
                }else if(i==2){
                    email.append(bufferedReader.readLine());
                }else if(i==3){
                    phone.append(bufferedReader.readLine());
                }
            }
            name.replace(0,6,"");
            age.replace(0,5,"");
            email.replace(0,7,"");
            phone.replace(0,7,"");
            profile.setName(String.valueOf(name));
            profile.setAge(Integer.valueOf(age.toString()));
            profile.setEmail(String.valueOf(email));
            profile.setPhone(Long.valueOf(phone.toString()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }
}
