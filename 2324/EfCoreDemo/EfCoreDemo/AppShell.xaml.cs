﻿using EfCoreDemo2;

namespace EfCoreDemoV2 {
    public partial class AppShell : Shell {
        public AppShell()
        {
            InitializeComponent();
            Routing.RegisterRoute("NewPupilPage", typeof(NewPupilPage));
        }
    }
}
