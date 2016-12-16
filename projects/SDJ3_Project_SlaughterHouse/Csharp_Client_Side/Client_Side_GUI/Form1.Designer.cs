namespace Client_Side_GUI
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.panel1 = new System.Windows.Forms.Panel();
            this.button1 = new System.Windows.Forms.Button();
            this.Complaints = new System.Windows.Forms.ListBox();
            this.button2 = new System.Windows.Forms.Button();
            this.ComplaintBox1 = new System.Windows.Forms.TextBox();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.panel4 = new System.Windows.Forms.Panel();
            this.AnimaIidBox1 = new System.Windows.Forms.TextBox();
            this.AnimalWaightBox2 = new System.Windows.Forms.TextBox();
            this.AnimalTypeBox3 = new System.Windows.Forms.TextBox();
            this.addAnimal = new System.Windows.Forms.Button();
            this.CuttingAnimalidBox1 = new System.Windows.Forms.TextBox();
            this.CutAnimalTrayidBox2 = new System.Windows.Forms.TextBox();
            this.CutPartidBox3 = new System.Windows.Forms.TextBox();
            this.CutPartTypeBox4 = new System.Windows.Forms.TextBox();
            this.CutButton = new System.Windows.Forms.Button();
            this.CutPartWaightBox1 = new System.Windows.Forms.TextBox();
            this.CutTrayWaightTotalBox1 = new System.Windows.Forms.TextBox();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.tabPage3.SuspendLayout();
            this.tabPage4.SuspendLayout();
            this.panel1.SuspendLayout();
            this.panel3.SuspendLayout();
            this.panel4.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Controls.Add(this.tabPage4);
            this.tabControl1.Location = new System.Drawing.Point(-1, 0);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(1104, 614);
            this.tabControl1.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.panel4);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(1096, 588);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Animal Station";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.panel3);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(1096, 588);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Cutting Station";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.panel2);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage3.Size = new System.Drawing.Size(1096, 588);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "Packing Station";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.panel1);
            this.tabPage4.Location = new System.Drawing.Point(4, 22);
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage4.Size = new System.Drawing.Size(1096, 588);
            this.tabPage4.TabIndex = 3;
            this.tabPage4.Text = "Customer Complaints";
            this.tabPage4.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.ComplaintBox1);
            this.panel1.Controls.Add(this.button2);
            this.panel1.Controls.Add(this.Complaints);
            this.panel1.Controls.Add(this.button1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel1.Location = new System.Drawing.Point(3, 3);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1090, 582);
            this.panel1.TabIndex = 0;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(927, 529);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(113, 33);
            this.button1.TabIndex = 0;
            this.button1.Text = "Send Complaint";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Complaints
            // 
            this.Complaints.FormattingEnabled = true;
            this.Complaints.Location = new System.Drawing.Point(17, 22);
            this.Complaints.Name = "Complaints";
            this.Complaints.Size = new System.Drawing.Size(271, 537);
            this.Complaints.TabIndex = 1;
            this.Complaints.SelectedIndexChanged += new System.EventHandler(this.Complaints_SelectedIndexChanged);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(314, 533);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(125, 28);
            this.button2.TabIndex = 2;
            this.button2.Text = "Handle Complaint";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // ComplaintBox1
            // 
            this.ComplaintBox1.Location = new System.Drawing.Point(330, 31);
            this.ComplaintBox1.Name = "ComplaintBox1";
            this.ComplaintBox1.RightToLeft = System.Windows.Forms.RightToLeft.No;
            this.ComplaintBox1.Size = new System.Drawing.Size(709, 20);
            this.ComplaintBox1.TabIndex = 3;
            this.ComplaintBox1.Text = "apply package id for complaint";
            this.ComplaintBox1.TextChanged += new System.EventHandler(this.ComplaintBox1_TextChanged);
            // 
            // panel2
            // 
            this.panel2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel2.Location = new System.Drawing.Point(3, 3);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(1090, 582);
            this.panel2.TabIndex = 0;
            // 
            // panel3
            // 
            this.panel3.Controls.Add(this.CutTrayWaightTotalBox1);
            this.panel3.Controls.Add(this.CutPartWaightBox1);
            this.panel3.Controls.Add(this.CutButton);
            this.panel3.Controls.Add(this.CutPartTypeBox4);
            this.panel3.Controls.Add(this.CutPartidBox3);
            this.panel3.Controls.Add(this.CutAnimalTrayidBox2);
            this.panel3.Controls.Add(this.CuttingAnimalidBox1);
            this.panel3.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel3.Location = new System.Drawing.Point(3, 3);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(1090, 582);
            this.panel3.TabIndex = 0;
            // 
            // panel4
            // 
            this.panel4.Controls.Add(this.addAnimal);
            this.panel4.Controls.Add(this.AnimalTypeBox3);
            this.panel4.Controls.Add(this.AnimalWaightBox2);
            this.panel4.Controls.Add(this.AnimaIidBox1);
            this.panel4.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panel4.Location = new System.Drawing.Point(3, 3);
            this.panel4.Name = "panel4";
            this.panel4.Size = new System.Drawing.Size(1090, 582);
            this.panel4.TabIndex = 0;
            // 
            // AnimaIidBox1
            // 
            this.AnimaIidBox1.Location = new System.Drawing.Point(36, 76);
            this.AnimaIidBox1.Name = "AnimaIidBox1";
            this.AnimaIidBox1.Size = new System.Drawing.Size(145, 20);
            this.AnimaIidBox1.TabIndex = 0;
            this.AnimaIidBox1.Text = "Enter id";
            this.AnimaIidBox1.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // AnimalWaightBox2
            // 
            this.AnimalWaightBox2.Location = new System.Drawing.Point(36, 124);
            this.AnimalWaightBox2.Name = "AnimalWaightBox2";
            this.AnimalWaightBox2.Size = new System.Drawing.Size(142, 20);
            this.AnimalWaightBox2.TabIndex = 1;
            this.AnimalWaightBox2.Text = "Enter waight";
            this.AnimalWaightBox2.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // AnimalTypeBox3
            // 
            this.AnimalTypeBox3.Location = new System.Drawing.Point(36, 173);
            this.AnimalTypeBox3.Name = "AnimalTypeBox3";
            this.AnimalTypeBox3.Size = new System.Drawing.Size(141, 20);
            this.AnimalTypeBox3.TabIndex = 2;
            this.AnimalTypeBox3.Text = "Enter type";
            this.AnimalTypeBox3.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            // 
            // addAnimal
            // 
            this.addAnimal.Location = new System.Drawing.Point(935, 512);
            this.addAnimal.Name = "addAnimal";
            this.addAnimal.Size = new System.Drawing.Size(115, 35);
            this.addAnimal.TabIndex = 3;
            this.addAnimal.Text = "Add Animal";
            this.addAnimal.UseVisualStyleBackColor = true;
            this.addAnimal.Click += new System.EventHandler(this.addAnimal_Click);
            // 
            // CuttingAnimalidBox1
            // 
            this.CuttingAnimalidBox1.Location = new System.Drawing.Point(23, 46);
            this.CuttingAnimalidBox1.Name = "CuttingAnimalidBox1";
            this.CuttingAnimalidBox1.Size = new System.Drawing.Size(156, 20);
            this.CuttingAnimalidBox1.TabIndex = 0;
            this.CuttingAnimalidBox1.Text = "Animal id";
            this.CuttingAnimalidBox1.TextChanged += new System.EventHandler(this.CuttingAnimalidBox1_TextChanged);
            // 
            // CutAnimalTrayidBox2
            // 
            this.CutAnimalTrayidBox2.Location = new System.Drawing.Point(23, 88);
            this.CutAnimalTrayidBox2.Name = "CutAnimalTrayidBox2";
            this.CutAnimalTrayidBox2.Size = new System.Drawing.Size(156, 20);
            this.CutAnimalTrayidBox2.TabIndex = 1;
            this.CutAnimalTrayidBox2.Text = "Tray id";
            this.CutAnimalTrayidBox2.TextChanged += new System.EventHandler(this.CutAnimalTrayidBox2_TextChanged);
            // 
            // CutPartidBox3
            // 
            this.CutPartidBox3.Location = new System.Drawing.Point(23, 132);
            this.CutPartidBox3.Name = "CutPartidBox3";
            this.CutPartidBox3.Size = new System.Drawing.Size(155, 20);
            this.CutPartidBox3.TabIndex = 2;
            this.CutPartidBox3.Text = "Part id";
            this.CutPartidBox3.TextChanged += new System.EventHandler(this.CutPartidBox3_TextChanged);
            // 
            // CutPartTypeBox4
            // 
            this.CutPartTypeBox4.Location = new System.Drawing.Point(23, 178);
            this.CutPartTypeBox4.Name = "CutPartTypeBox4";
            this.CutPartTypeBox4.Size = new System.Drawing.Size(155, 20);
            this.CutPartTypeBox4.TabIndex = 3;
            this.CutPartTypeBox4.Text = "Part type";
            this.CutPartTypeBox4.TextChanged += new System.EventHandler(this.CutPartTypeBox4_TextChanged);
            // 
            // CutButton
            // 
            this.CutButton.Location = new System.Drawing.Point(940, 527);
            this.CutButton.Name = "CutButton";
            this.CutButton.Size = new System.Drawing.Size(131, 40);
            this.CutButton.TabIndex = 4;
            this.CutButton.Text = "Cut to tray";
            this.CutButton.UseVisualStyleBackColor = true;
            this.CutButton.Click += new System.EventHandler(this.CutButton_Click);
            // 
            // CutPartWaightBox1
            // 
            this.CutPartWaightBox1.Location = new System.Drawing.Point(25, 224);
            this.CutPartWaightBox1.Name = "CutPartWaightBox1";
            this.CutPartWaightBox1.Size = new System.Drawing.Size(152, 20);
            this.CutPartWaightBox1.TabIndex = 5;
            this.CutPartWaightBox1.Text = "Part waight";
            this.CutPartWaightBox1.TextChanged += new System.EventHandler(this.CutPartWaightBox1_TextChanged);
            // 
            // CutTrayWaightTotalBox1
            // 
            this.CutTrayWaightTotalBox1.Location = new System.Drawing.Point(753, 547);
            this.CutTrayWaightTotalBox1.Name = "CutTrayWaightTotalBox1";
            this.CutTrayWaightTotalBox1.ReadOnly = true;
            this.CutTrayWaightTotalBox1.Size = new System.Drawing.Size(155, 20);
            this.CutTrayWaightTotalBox1.TabIndex = 6;
            this.CutTrayWaightTotalBox1.TextChanged += new System.EventHandler(this.CutTrayWaightTotalBox1_TextChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1101, 614);
            this.Controls.Add(this.tabControl1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.tabPage3.ResumeLayout(false);
            this.tabPage4.ResumeLayout(false);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.panel3.ResumeLayout(false);
            this.panel3.PerformLayout();
            this.panel4.ResumeLayout(false);
            this.panel4.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox ComplaintBox1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.ListBox Complaints;
        private System.Windows.Forms.Panel panel4;
        private System.Windows.Forms.Button addAnimal;
        private System.Windows.Forms.TextBox AnimalTypeBox3;
        private System.Windows.Forms.TextBox AnimalWaightBox2;
        private System.Windows.Forms.TextBox AnimaIidBox1;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.TextBox CutTrayWaightTotalBox1;
        private System.Windows.Forms.TextBox CutPartWaightBox1;
        private System.Windows.Forms.Button CutButton;
        private System.Windows.Forms.TextBox CutPartTypeBox4;
        private System.Windows.Forms.TextBox CutPartidBox3;
        private System.Windows.Forms.TextBox CutAnimalTrayidBox2;
        private System.Windows.Forms.TextBox CuttingAnimalidBox1;
    }
}

