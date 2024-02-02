using System.Net.Http.Json;
using System.Text.Json;
using ConsoleApp;
HttpClient httpClient = new()
{
    BaseAddress = new Uri("https://lldev.thespacedevs.com/2.2.0/launch/")
};
LaunchListResponse todos = await httpClient.GetFromJsonAsync<LaunchListResponse>("https://lldev.thespacedevs.com/2.2.0/launch/");


var data = todos.Results.Where(r => r.Status.Id ==3).Select(d=>d.Status.Name);
foreach (var item in data)
{
    Console.WriteLine("-------------------------------------------------------------");
    Console.WriteLine(item);
}
Console.WriteLine("finished");
string temp = Console.ReadLine();
