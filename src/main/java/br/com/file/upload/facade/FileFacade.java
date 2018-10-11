package br.com.file.upload.facade;

import br.com.file.upload.db.local.FileDb;
import br.com.file.upload.model.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FileFacade {

    private static final Logger _logger = LoggerFactory.getLogger(FileFacade.class);

    public static List<File> readAll() {

        return FileDb.getInstance().readAll();
    }

    public static void upload(File files[]) {

        for(File file: files) {
            FileDb.getInstance().insert(file);
        }
    }

    public static void delete(int id) {

        FileDb.getInstance().delete(id);
    }
}
