
package com.mycompany.consultarmedicopersistencia.ConexionBD;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 * Clase para manejar la conexión con la base de datos MongoDB.
 */
public class Conexion {

    private static final String nombreBaseDatos = "Medicos";
    private static final String cadenaConexion = "mongodb://localhost:27017";
    private static MongoClient mongoClient = null;

    public Conexion() {
    }

    /**
     * Método para obtener la base de datos MongoDB.
     *
     * @return La base de datos MongoDB.
     */
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(cadenaConexion)).
                    codecRegistry(pojoCodecRegistry)
                    .build();

            mongoClient = MongoClients.create(clientSettings);

            return mongoClient.getDatabase(nombreBaseDatos).withCodecRegistry(pojoCodecRegistry);
        }
        return mongoClient.getDatabase(nombreBaseDatos);
    }

    /**
     * Método para cerrar la conexión con la base de datos MongoDB.
     */
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
