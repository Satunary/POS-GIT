using EfCoreDemoV2.ViewModels;

namespace EfCoreDemo2;

public partial class NewExamPage : ContentPage
{
	ExamViewModel e = new ExamViewModel();
	public NewExamPage()
	{
		InitializeComponent();
		BindingContext = e;
	}
}