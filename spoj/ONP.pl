
@op		= qw();

$test = <>;
for ($tt = 0; $tt<$test; $tt++){
	$line = <>;
	for ($i = 0; $i<length($line); $i++){
		$char =  substr($line, $i, 1);
		if ($char=~/\)/) {
			$tmp1 = pop @op;
			substr($line,$i,0) = substr($line,$tmp1,1);
			substr($line,$tmp1,1) = "";
		}
		elsif ($char !~ /[a-z]/){
			push(@op, $i);
		}
	} $line=~s/\(|\)//g;
	print $line;
}
