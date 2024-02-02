using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp;


public record LaunchListResponse
{
    public int Count { get; init; }
    public string Next { get; init; }
    public LaunchListResponse Previous { get; init; }
    public List<LaunchInfoV3> Results { get; init; }
}

public record LaunchInfoV3
{
    public string Id { get; init; }
    public string Url { get; init; }
    public string Slug { get; init; }
    public string Name { get; init; }
    public LaunchStatusV3 Status { get; init; }
    public DateTime LastUpdated { get; init; }
    public DateTime Net { get; init; }
    public DateTime WindowEnd { get; init; }
    public DateTime WindowStart { get; init; }
    public int? NetPrecision { get; init; }
    public double? Probability { get; init; }
    public string WeatherConcerns { get; init; }
    public string HoldReason { get; init; }
    public string FailReason { get; init; }
    public string Hashtag { get; init; }
    public LaunchServiceProviderV3 LaunchServiceProvider { get; init; }
    public RocketInfoV3 Rocket { get; init; }
    public MissionInfoV3 Mission { get; init; }
    public PadInfoV3 Pad { get; init; }
    public bool WebcastLive { get; init; }
    public string Image { get; init; }
    public string Infographic { get; init; }
    public List<object> Program { get; init; }
    public int OrbitalLaunchAttemptCount { get; init; }
    public int LocationLaunchAttemptCount { get; init; }
    public int PadLaunchAttemptCount { get; init; }
    public int AgencyLaunchAttemptCount { get; init; }
    public int OrbitalLaunchAttemptCountYear { get; init; }
    public int LocationLaunchAttemptCountYear { get; init; }
    public int PadLaunchAttemptCountYear { get; init; }
    public int AgencyLaunchAttemptCountYear { get; init; }
    public string Type { get; init; }
}

public record LaunchStatusV3
{
    public int Id { get; init; }
    public string Name { get; init; }
    public string Abbrev { get; init; }
    public string Description { get; init; }
}

public record LaunchServiceProviderV3
{
    public int Id { get; init; }
    public string Url { get; init; }
    public string Name { get; init; }
    public string Type { get; init; }
}

public record RocketInfoV3
{
    public int Id { get; init; }
    public RocketConfigurationV3 Configuration { get; init; }
}

public record RocketConfigurationV3
{
    public int Id { get; init; }
    public string Url { get; init; }
    public string Name { get; init; }
    public string Family { get; init; }
    public string FullName { get; init; }
    public string Variant { get; init; }
}

public record MissionInfoV3
{
    public int Id { get; init; }
    public string Name { get; init; }
    public string Description { get; init; }
    public string LaunchDesignator { get; init; }
    public string Type { get; init; }
    public OrbitInfoV3 Orbit { get; init; }
    public List<object> Agencies { get; init; }
    public List<object> InfoUrls { get; init; }
    public List<object> VidUrls { get; init; }
}

public record OrbitInfoV3
{
    public int Id { get; init; }
    public string Name { get; init; }
    public string Abbrev { get; init; }
}

public record PadInfoV3
{
    public int Id { get; init; }
    public string Url { get; init; }
    public int? AgencyId { get; init; }
    public string Name { get; init; }
    public string Description { get; init; }
    public string InfoUrl { get; init; }
    public string WikiUrl { get; init; }
    public string MapUrl { get; init; }
    public string Latitude { get; init; }
    public string Longitude { get; init; }
    public LocationInfoV3 Location { get; init; }
    public string CountryCode { get; init; }
    public string MapImage { get; init; }
    public int TotalLaunchCount { get; init; }
    public int OrbitalLaunchAttemptCount { get; init; }
}

public record LocationInfoV3
{
    public int Id { get; init; }
    public string Url { get; init; }
    public string Name { get; init; }
    public string CountryCode { get; init; }
    public string Description { get; init; }
    public string MapImage { get; init; }
    public string TimezoneName { get; init; }
    public int TotalLaunchCount { get; init; }
    public int TotalLandingCount { get; init; }
}

public class WorkWithHttpClient
{
    public async Task<List<LaunchListResponse>> ReadTodosAsync(HttpClient httpClient)
    {
        var response = await httpClient.GetFromJsonAsync<LaunchListResponse[]>("https://lldev.thespacedevs.com/2.2.0/launch/");
        if (response is null)
        {
            Console.WriteLine("Error: No data received");
            return new();
        }
        return response.ToList();
    }

}


