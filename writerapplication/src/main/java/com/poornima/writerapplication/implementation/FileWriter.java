package com.poornima.writerapplication.implementation;
import com.poornima.writerapplication.constants.Constants;
import com.poornima.writerapplication.service.GenearlService;
import com.poornima.writerapplication.service.IWriterService;
import com.poornima.writerapplication.valueobject.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Service
public class FileWriter implements IWriterService {
    @Autowired
    GenearlService genearlService;

    @Override
    public String writer(String str, List<Operation> operationList) {

        if(!operationList.isEmpty()){
            for(Operation op : operationList){
                str = genearlService.generalOperation(str, op);
            }
        }
        LocalDate today = LocalDate.now();
        String filePath = Constants.FILE_PATH+"FileWriter"+today+".txt";
        File file = new File(filePath);
        try(FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = str.getBytes();
            bos.write(bytes);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }
    public String readFromFile(String fileName){
        Path filePath = Path.of(Constants.FILE_PATH+fileName+".txt");
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath))))
        {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}
