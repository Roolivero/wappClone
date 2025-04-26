package com.wappClone.config

import org.hibernate.dialect.Dialect
import org.hibernate.dialect.function.StandardSQLFunction
import org.hibernate.dialect.function.SQLFunctionTemplate
import org.hibernate.dialect.function.VarArgsSQLFunction
import org.hibernate.type.StringType
import java.sql.Types

class SQLiteDialect : Dialect() {

    init {
        registerColumnType(Types.BIT, "boolean")
        registerColumnType(Types.TINYINT, "tinyint")
        registerColumnType(Types.SMALLINT, "smallint")
        registerColumnType(Types.INTEGER, "integer")
        registerColumnType(Types.BIGINT, "bigint")
        registerColumnType(Types.FLOAT, "float")
        registerColumnType(Types.DOUBLE, "double")
        registerColumnType(Types.VARCHAR, "varchar")
        registerColumnType(Types.CHAR, "char")
        registerColumnType(Types.LONGVARCHAR, "longvarchar")
        registerColumnType(Types.DATE, "date")
        registerColumnType(Types.TIME, "time")
        registerColumnType(Types.TIMESTAMP, "datetime")
        registerColumnType(Types.BINARY, "blob")
        registerColumnType(Types.VARBINARY, "blob")
        registerColumnType(Types.LONGVARBINARY, "blob")
        registerColumnType(Types.BLOB, "blob")
        registerColumnType(Types.CLOB, "clob")
        registerColumnType(Types.BOOLEAN, "boolean")

        // Funciones comunes
        registerFunction("concat", VarArgsSQLFunction(StringType(), "", "||", ""))
        registerFunction("mod", SQLFunctionTemplate(StringType(), "?1 % ?2"))
        registerFunction("substr", StandardSQLFunction("substr", StringType()))
        registerFunction("substring", StandardSQLFunction("substr", StringType()))
    }

    override fun getIdentityColumnString(): String = "integer"

    override fun getIdentitySelectString(): String = "select last_insert_rowid()"

    override fun hasAlterTable(): Boolean = false

    override fun dropConstraints(): Boolean = false

    override fun getAddColumnString(): String = "add column"

    override fun getForUpdateString(): String = ""

    override fun supportsIdentityColumns(): Boolean = true

    override fun supportsTemporaryTables(): Boolean = true

    override fun getCreateTemporaryTableString(): String = "create temporary table if not exists"

    override fun supportsCurrentTimestampSelection(): Boolean = true

    override fun isCurrentTimestampSelectStringCallable(): Boolean = false

    override fun getCurrentTimestampSelectString(): String = "select current_timestamp"

    override fun supportsUnionAll(): Boolean = true

    override fun hasLimit(): Boolean = true

    override fun getLimitString(query: String, offset: Int, limit: Int): String {
        return "$query limit $limit offset $offset"
    }
}
