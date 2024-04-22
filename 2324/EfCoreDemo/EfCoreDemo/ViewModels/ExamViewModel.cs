using CommunityToolkit.Mvvm.ComponentModel;
using CommunityToolkit.Mvvm.Input;
using EfCoreDemoV2.Dto;
using EfCoreDemoV2.Model;
using EfCoreDemoV2.ViewModels;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace EfCoreDemo2.ViewModels
{
   public class ExamViewModel:ObservableObject
    {
        private readonly SchoolDb _db = new SchoolDb();

        private bool _examWritableEntry;
        public bool ExamReadOnlyEntry { get { return _examWritableEntry; } set { SetProperty(ref _examWritableEntry, value); } }

        private bool _examWritablePicker;
        public bool ExamEnabledPicker { get { return _examWritablePicker; } set { SetProperty(ref _examWritablePicker, value); } }

        public ICommand SaveExamCommand { get; }

        public ExamViewModel()
        {
            SaveExamCommand = new RelayCommand(SaveExam);
        }

        

        private void SaveExam()
        {
            Exam e = MainViewModel.Instance.CurrentExam;

            if (e is null || e.Grade == 0 || e.Subject.Length < 1) { return; }
            _db.Exams.Add(e);
            MainViewModel.Instance.Exams.Add(e);

           ExamReadOnlyEntry = true;
           ExamEnabledPicker = false;
        }
    }
}
