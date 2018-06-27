package digitalmetering

import org.apache.commons.csv.CSVParser._
import org.apache.commons.csv._
import org.apache.commons.csv.CSVFormat._
import java.io.FileReader

import scala.collection.JavaConverters._

object dataReader {

  val file = new FileReader("data/uniMelb.csv")

  val uniMelbformat = CSVFormat.RFC4180.withSkipHeaderRecord(true).withIgnoreEmptyLines(true)

  val parser = CSVParser.parse(file, uniMelbformat)

  val rows = parser.getRecords.asScala

  // val items = rows.iterator().dropWhile(_.iterator().next().isEmpty())
  val items = rows.drop(2)

  def collectRecords(x: CSVRecord): timeStamp = {

    val values = x.iterator()
    val timestamp = values.next()
    val flow = values.next()
    timeStamp(timestamp, flow.toInt)

  }

  val records = items.map(r => collectRecords(r)).toSeq



}



