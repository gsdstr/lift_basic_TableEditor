package code.snippet

import code.model._

import xml.{NodeSeq, Text}

import net.liftweb.{http, mapper, util}
import http.js.JsCmds.Run
import http.js.JsCmds.{Run, Script}
import http.S
import http.SHtml
import mapper._
import util.BindPlus._
import util.{BindHelpers, Helpers}
import Helpers._
import S.?


import view.Util.eachField
import view.{Util, ItemsList, ItemsListEditor}
import net.liftweb.common.{Full, Loggable}

/**
 * User: gsd
 * Date: 05.12.12
 * Time: 19:00
 */

class ExpenseCategoryEditor extends ItemsListEditor[ExpenseCategory] with Loggable {
	val items = new ItemsList[ExpenseCategory] {
		def metaMapper = ExpenseCategory
	}
	
	def title = "Cats"

	val noPrompt = "onclick" -> "safeToContinue=true"

	def bindTable = "#title" #> title &
		"#fields" #> eachField[ExpenseCategory](
			items.metaMapper,
			(f: MappedField[_, ExpenseCategory]) => Seq(
				"name" -> SHtml.link(S.uri, sortFn(f), Text(capify(f.displayName)))
			),
			fieldFilter
		) &
		"#insertBtn" #> SHtml.submit(?("Insert"), onInsert _, noPrompt)
}