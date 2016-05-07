package cz.bartos.smarthome.beans;

import cz.bartos.smarthome.domain.Role;
import cz.bartos.smarthome.domain.User;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Míra
 */
@Named
@Singleton
public class AuthorizationBean implements Serializable {

    public static final Map<String, Role> accessMap;

    static {
        accessMap = new HashMap<>();
        try {
            Path path = Paths.get("");
            ByteBuffer buffer = ByteBuffer.allocate((int) Files.size(path));
            FileChannel fileChannel = FileChannel.open(path);
            fileChannel.read(buffer);
            String content = new String(buffer.array());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     public boolean hasAccess(User user, String requestURI) {
     Role role = accessMap.get(requestURI);
     return role != null && user.getRole() == role;
     }
     */
}
