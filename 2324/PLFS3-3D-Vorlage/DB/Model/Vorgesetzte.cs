﻿using System;
using System.Collections.Generic;

namespace DB.Model;

public partial class Vorgesetzte
{
    public string VLVorg { get; set; } = null!;

    public string VArt { get; set; } = null!;

    public string VLUnt { get; set; } = null!;

    public virtual Lehrer VLUntNavigation { get; set; } = null!;

    public virtual Lehrer VLVorgNavigation { get; set; } = null!;
}
