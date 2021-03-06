package com.demo.spark

import org.apache.log4j.{Logger,Level}
import org.apache.spark._
import org.apache.spark.SparkContext._

object ReviewCounter {
def main(arr:Array[String]): Unit ={
  // Set the log level to only print errors
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Create a SparkContext using every core of the local machine, named RatingsCounter
  val sc = new SparkContext("local[*]", "ReviewsCounter")

  // Load up each line of the ratings data into an RDD
  val lines = sc.textFile("C:/Users/hchandra/Desktop/SparkScala/data/ml-100k/u.data")

  // Convert each line to a string, split it out by tabs, and extract the third field.
  // (The file format is userID, movieID, rating, timestamp)
  //val ratings = lines.map(x => x.toString().split("\t")(2))
  val ratings = lines.map(x => x.toString().split("\t")(2)).map(x=>(x,1))

  // Count up how many times each value (rating) occurs
  //val results = ratings.countByValue()

  val results = ratings.reduceByKey(_+_).sortBy(_._1)
  results.foreach(println)
  // Sort the resulting map of (rating, count) tuples
  //val sortedResults = results.toSeq.sortBy(_._1)

  // Print each result on its own line.
  //sortedResults.foreach(println)
}
}
