package br.com.file.upload.facade;

import br.com.file.upload.model.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.time.LocalDateTime;

public class FileFacade {

    private static final Logger _logger = LoggerFactory.getLogger(FileFacade.class);

    public static void upload(File files[]) {

        LocalDateTime now = LocalDateTime.now();
        String path = "tmp" + java.io.File.separator + now.getYear() + java.io.File.separator + now.getMonth().getValue() + java.io.File.separator;
        new java.io.File(path).mkdirs();

        for(File file: files) {
            try {
                FileOutputStream outputStream = new FileOutputStream(path + file.getName());
                outputStream.write(file.getContent());
                outputStream.close();
            } catch (Exception e) {
                _logger.error("Erro ao Salvar arquivo: " + file.getName(), e);
            }
        }
    }
}
