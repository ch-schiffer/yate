using System;
using System.IO;
using System.Text;
 
private class Program
{
  public static void Main()
  {
    //Text, der in die Datei geschrieben wird
    const string textToWrite = "Hallo Welt";
    const string fileName = "dateiname.txt";
 
    //Datei "dateiname.txt" wird erstellt oder überschrieben
    using (var stream = new FileStream(fileName, FileMode.Create, FileAccess.Write))
    {
       //Der Text wird UTF8-kodiert in die Datei geschrieben
       var data = Encoding.UTF8.GetBytes(textToWrite);
       stream.Write(data, 0, data.Length);
       //Datei wird geschlossen..
    }
  }
}