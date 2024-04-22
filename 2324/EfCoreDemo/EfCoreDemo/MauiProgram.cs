using CommunityToolkit.Maui;
using EfCoreDemoV2.Model;
using EfCoreDemoV2.ViewModels;
using Microsoft.Extensions.Logging;

namespace EfCoreDemoV2 {
    public static class MauiProgram {
        public static MauiApp CreateMauiApp()
        {
            var builder = MauiApp.CreateBuilder();
            builder
                .UseMauiCommunityToolkit()
                .UseMauiApp<App>()
                .ConfigureFonts(fonts =>
                {
                    fonts.AddFont("OpenSans-Regular.ttf", "OpenSansRegular");
                    fonts.AddFont("OpenSans-Semibold.ttf", "OpenSansSemibold");
                });

#if DEBUG
    		builder.Logging.AddDebug();
#endif

            using (var db = new SchoolDb())
            {
                db.Database.EnsureDeleted();
                db.Database.EnsureCreated();
                db.Seed();
            }
            builder.Services.AddSingleton<MainViewModel>();

            return builder.Build();
        }
    }
}
