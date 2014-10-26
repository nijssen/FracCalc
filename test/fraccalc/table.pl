#!perl

use strict;
use warnings;
use Text::Table;
use FindBin;

my $t = Text::Table->new(
	map { { title => $_, align => "left", align_title => "left" } }
	qw/! EXPR EXPECTED ACTUAL/
);

open EXPR, "<", "$FindBin::Bin/ggg.txt" or die $!;
open EXPECT, "<", "$FindBin::Bin/expected.txt" or die $!;
open RESULT, "<", "$FindBin::Bin/res.txt" or die $!;
open OUT, ">", "$FindBin::Bin/cmp.txt" or die $!;

my($x, $res, $ex);
$t->load(
	map { [ reverse(($res = f(*RESULT)), ($ex = f(*EXPECT)), $_, ($ex eq $res ? "" : "!")) ] }
	map { $_->[1] }
	map { [ chomp($_), $_ ] }
	<EXPR>
);

print OUT $t;

sub f {
	local *FH = shift;
	chomp(my $r = <FH>);
	
	return $r;
}
