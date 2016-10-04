package lyrical.alejandro.bd_sqlite;

import android.provider.BaseColumns;


/**
 * Classe Contract. Defineix constants per la base de dades.
 */
public final class DBContract {
    // Inicialització de les variables comunes que s'utilitzaran per la creació de les taules
    public static final  int    DATABASE_VERSION   = 1;               // Versió de la bd
    public static final  String DATABASE_NAME      = "dbexample.db";  // Nom de la bd
    private static final String TEXT_TYPE          = " TEXT";         // Tipus de text
    private static final String INTEGER_TYPE       = " INTEGER";      // Tipus d'enter
    private static final String COMMA_SEP          = ",";             // Separació

    /**
     * Constructora. Se sol definir així per tal que la crida de la constructora de la classe
     * Contract no tingui cap efecte.
     */
    private DBContract() {}

    /**
     * Classe Table1 (usuaris).
     */

    public static abstract class Table1 implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_COL1 = "name";
        public static final String COLUMN_NAME_COL2 = "email";

        // String que proporciona la creació de la taula "Table1"
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_NAME_COL1 + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_COL2 + TEXT_TYPE + " UNIQUE )";

        // String que proporciona l'eliminació de la taula "Table1"
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * Classe Table2 (xarxes socials).
     */
    public static abstract class Table2 implements BaseColumns {
        public static final String TABLE_NAME       = "social";
        public static final String COLUMN_NAME_COL1 = "name";
        public static final String COLUMN_NAME_COL2 = "counter";

        // String que proporciona la creació de la taula "Table2"
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_NAME_COL1 + TEXT_TYPE + " UNIQUE" + COMMA_SEP +
            COLUMN_NAME_COL2 + INTEGER_TYPE + " )";

        // String que proporciona l'eliminació de la taula "Table2"
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * Classe Table12 (interrelació n a m entre usuaris i xarxes socials).
     */
    public static abstract class Table12 implements BaseColumns {
        public static final String TABLE_NAME       = "relation";
        public static final String COLUMN_NAME_COL1 = "email";
        public static final String COLUMN_NAME_COL2 = "name";
        public static final String COLUMN_NAME_COL3 = "register_date";

        // String que proporciona la creació de la taula "Table12"
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_NAME_COL1 + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_COL2 + TEXT_TYPE + COMMA_SEP +
            COLUMN_NAME_COL3 + TEXT_TYPE + " )";

        // String que proporciona l'eliminació de la taula "Table12"
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
