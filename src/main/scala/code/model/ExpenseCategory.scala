package code.model

import net.liftweb.mapper._
import net.liftweb.util.A

/**
 * User: gsd
 * Date: 06.12.12
 * Time: 10:29
 */

class ExpenseCategory extends LongKeyedMapper[ExpenseCategory] with IdPK  {
	def getSingleton = ExpenseCategory

	def canDelete = true

	object amount extends MappedInt(this)

	object name extends MappedString[ExpenseCategory](this, 100)
}

object ExpenseCategory extends ExpenseCategory with LongKeyedMetaMapper[ExpenseCategory]{
	override def dbTableName = "cats"
}