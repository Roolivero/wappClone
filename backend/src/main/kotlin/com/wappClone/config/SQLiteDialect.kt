package com.wappClone.config

import org.hibernate.dialect.Dialect
import org.hibernate.dialect.function.StandardSQLFunction
import org.hibernate.dialect.function.SQLFunctionTemplate
import org.hibernate.dialect.function.VarArgsSQLFunction
import org.hibernate.type.StringType
import org.hibernate.dialect.identity.IdentityColumnSupportImpl
import org.hibernate.dialect.identity.IdentityColumnSupport

class SQLiteDialect : Dialect() {

    override fun getIdentityColumnSupport(): IdentityColumnSupport {
        return object : IdentityColumnSupportImpl() {
            override fun supportsIdentityColumns() = true
            override fun getIdentitySelectString(table: String?, column: String?, type: Int): String {
                return "select last_insert_rowid()"
            }

            override fun getIdentityColumnString(type: Int): String {
                return "integer"
            }
        }
    }

    override fun hasAlterTable() = false
    override fun dropConstraints() = false
    override fun getDropForeignKeyString() = ""

    override fun getAddForeignKeyConstraintString(
        constraintName: String?,
        foreignKey: Array<out String>?,
        referencedTable: String?,
        primaryKey: Array<out String>?,
        referencesPrimaryKey: Boolean
    ): String = ""

    override fun getAddPrimaryKeyConstraintString(constraintName: String?): String = ""

    override fun supportsIfExistsBeforeTableName() = true
}
