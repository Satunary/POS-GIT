namespace Lab16
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
            var motorcyleVM = new MotorcycleViewModel();
            BindingContext = motorcyleVM;      
        }

        private void MotorcycleColView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
    }

}
